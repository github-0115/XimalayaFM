package ximalayafm.beiing.com.ximalayafm.entity.album_detail;

import org.json.JSONException;
import org.json.JSONObject;

import ximalayafm.beiing.com.ximalayafm.entity.Parsable;

/**
 * Date:2015/11/1
 * Author:Beiing
 * Email:15764230067@163.com
 **/

public class TrackComment implements Parsable{


    /**
     * id : 13174525
     * track_id : 8060450
     * uid : 28675276
     * nickname : 中医养生传道电台
     * smallHeader : http://fdfs.xmcdn.com/group10/M08/21/13/wKgDZ1V7_azBULi6AAG3ijTFAwY722_mobile_small.jpg
     * content : 大家来听我深刻讲解中医吧！！！！！，我为大家分析为什么睡眠不好，中药怎么祛痘，肾虚会什么会记忆力下降， 中药为什么会无效，虚不受补，肾虚会疲劳，性能力下降，跟我学中医吧，您会学到很多东西！！！！！
     * createdAt : 1438369920000
     * parentId : 13174525
     */

    private long id;
    private long track_id;
    private long uid;
    private String nickname;
    private String smallHeader;
    private String content;
    private long createdAt;
    private long parentId;


    @Override
    public void parseJson(JSONObject json) throws JSONException {
        if (json != null) {
            id = json.getLong("id");
            track_id = json.getLong("track_id");
            uid = json.getLong("uid");
            nickname = json.getString("nickname");
            smallHeader = json.getString("smallHeader");
            content = json.getString("content");
            createdAt = json.getLong("createdAt");
            parentId = json.getLong("parentId");
        }
    }
}









