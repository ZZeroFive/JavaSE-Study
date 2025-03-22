package ml.generic.study.actual01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class DemoService {

    public PageResult<User> selectUserByPage() {
        JSONObject obj = new JSONObject();
        obj.put("sName", "ZhangSan");
        // 假设从ES中读取到1个数据
        User u = JSONObject.parseObject(obj.toJSONString(), User.class);

        // 现在构造PageResult 即如何正确使用该类 传递一个字节码对象即可
        PageResult<User> result = PageResult.geneEmptyResult(User.class);
        result.setTotal(1L);
        result.getData().add(u);
        System.out.println(JSON.toJSONString(result));
        return result;
    }

    public static void main(String[] args) {
        new DemoService().selectUserByPage();
    }
}
