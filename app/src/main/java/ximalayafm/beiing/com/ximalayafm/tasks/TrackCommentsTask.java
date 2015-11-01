package ximalayafm.beiing.com.ximalayafm.tasks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ximalayafm.beiing.com.ximalayafm.TaskAction;
import ximalayafm.beiing.com.ximalayafm.client.ClientAPI;
import ximalayafm.beiing.com.ximalayafm.entity.album_detail.TrackComment;
import ximalayafm.beiing.com.ximalayafm.utils.EntityParseUtil;

/**
 * Date:2015/11/1
 * Author:Beiing
 * Email:15764230067@163.com
 **/

public class TrackCommentsTask  extends BaseTask{

    public TrackCommentsTask(TaskCallBack callBack) {
        super(callBack);
    }

    @Override
    protected TaskResult doInBackground(String... strings) {
        TaskResult ret = new TaskResult();
        ret.action = TaskAction.TASK_ACTION_TRACK_COMMENTS;
        if(strings != null && strings.length > 0) {
            //得到下载网址
            String url = strings[0];
            JSONObject commentsJson = ClientAPI.getTrackComments(url);

            if (commentsJson != null) {
                try {
                    ret.resultCode = commentsJson.getInt("ret");

                    List<TrackComment> commentses = new ArrayList<>();

                    JSONArray ja_list = commentsJson.getJSONArray("list");
                    int len = ja_list.length();
                    for (int i = 0; i < len; i++) {
                        JSONObject j_comm = ja_list.getJSONObject(i);
                        TrackComment trackComment = new TrackComment();
                        trackComment.parseJson(j_comm);
                        commentses.add(trackComment);
                    }

                    //解析数据
                    ret.data = commentses;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
}







