package com.core.models;

import com.google.gson.Gson;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class PlayerDemo {
    @Inject
    String[] playerInfo;
    List<PlayerDetail> pl = new ArrayList<PlayerDetail>();
    public String getMessage(){
        return "new getMessage";
    }
    public List<PlayerDetail> getPlayerDetails(){

        for(String player : playerInfo) {

            Gson gson = new Gson();

            PlayerDetail fooFromJson = gson.fromJson(player, PlayerDetail.class);

            pl.add(fooFromJson);

        }

        return pl;
    }



    public class PlayerDetail{
        String name;
        String desc;
        String file;

        public String getName() {
            return name;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public void setName(String name) {
            this.name = name;


        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
