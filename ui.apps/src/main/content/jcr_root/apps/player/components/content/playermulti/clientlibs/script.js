/*
 ADOBE CONFIDENTIAL
 __________________

  Copyright 2012 Adobe Systems Incorporated
  All Rights Reserved.

 NOTICE:  All information contained herein is, and remains
 the property of Adobe Systems Incorporated and its suppliers,
 if any.  The intellectual and technical concepts contained
 herein are proprietary to Adobe Systems Incorporated and its
 suppliers and are protected by trade secret or copyright law.
 Dissemination of this information or reproduction of this material
 is strictly forbidden unless prior written permission is obtained
 from Adobe Systems Incorporated.
 */

jQuery(function ($) {

    var isWCMEdit = false,
        isClassicUIAuthor  = ("CQ" in window && "WCM" in CQ && typeof CQ.WCM.getTopWindow != "undefined"),
        CQTop = isClassicUIAuthor ? CQ.WCM.getTopWindow().CQ : null;

    $(".tabctrl").each(function () {
        var tabctrl   = $(this);

        // Called when clicking on a tab link
        function switchTab() {
            var link       = $(this),
                newItem    = link.closest("li"),
                oldItem    = tabctrl.find(".tabctrl-header li.active"),
                newContent = tabctrl.find(link.attr("href")),
                oldContent = tabctrl.find(".tabctrl-content:visible");

            if (!newItem.is(oldItem)) {
                oldItem.removeClass("active");
                newItem.addClass("active");

                if (isWCMEdit) {
                    oldContent.hide();
                    newContent.show();
                    toggleEditables(false, oldContent.attr("data-path"));
                    toggleEditables(true, newContent.attr("data-path"));
                } else {
                    oldContent.fadeOut();
                    newContent.fadeIn();
                    tabctrl.find(".tabctrl-container").animate({"height": newContent.height()});
                    tabctrl.find(".tabctrl-container").animate({"height": newContent.height()}, function() {
                        $(this).css("height", "auto");
                    });
                }
            }
            return false;
        }

        function setTabHeight() {
            if (isWCMEdit) {
                tabctrl.find(".tabctrl-container").css("height", "auto");
                tabctrl.find(".tabctrl-content:hidden").each(function () {
                    if (isClassicUIAuthor) {
                        toggleEditables(false, $(this).attr("data-path"));
                    }
                });
            } else {
                tabctrl.find(".tabctrl-container").height(tabctrl.find(".tabctrl-content:visible").height());
            }
        }

        function updateWCM() {
            setTimeout(function () {
                if (CQTop) {
                    isWCMEdit = CQTop.WCM.isEditMode();
                }

                setTabHeight();
            }, 1);
        }

        // Initialization
        tabctrl.find(".tabctrl-header a").bind("click.tabctrl", switchTab);
        tabctrl.find(".tabctrl-header li:first").addClass("active");
        tabctrl.find(".tabctrl-content:gt(0)").hide();
        tabctrl.find(".tabctrl-container").animate({"height": tabctrl.find(".tabctrl-content:first").height()}, function() {
            $(this).css("height", "auto");
        });

        if (isClassicUIAuthor) {
            if (CQTop) {
                CQTop.WCM.on("wcmmodechange", updateWCM);
                CQTop.WCM.on("sidekickready", updateWCM);
            }

            CQ.WCM.on("editablesready", updateWCM);
        } else {
            setTabHeight();
        }
    });

    // Shows/Hides the ClassicUI component widgets
    // The optional filter argument offers the possibility to limit the effect
    // only to the components below the provided content path
    function toggleEditables(show, filter) {
        filter = filter && filter.replace("/_jcr_content/", "/jcr:content/");
        var editables = CQ.WCM.getEditables();
        for (var path in editables) {
            if (!filter || path.indexOf(filter) == 0) {
                var editable = editables[path],
                    placeholder = editable.getInlinePlaceholder();

                editable[show ? "show" : "hide"]();

                if (placeholder) {
                    placeholder.setWidth("auto");
                }
            }
        }
    }

});
