package servlet;

import com.fasterxml.jackson.databind.JsonNode;
import util.HttpClientUtil;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 微信登录控制器
 *
 * @author hui
 * @date 2021-01-15 18:26:42
 */
@WebServlet("/wechat")
public class WechatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //自己公众号的appid和appsecret
        String appid = "换成自己的appid";
        String appsecret = "换成自己的appsecret";
        //获取微信返回的code
        String code = request.getParameter("code");
        //通过code换取网页授权access_token
        String tokenApi = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid +
                "&secret=" + appsecret +
                "&code=" + code +
                "&grant_type=authorization_code";
        JsonNode tokenNode = JsonUtil.parse2json(HttpClientUtil.doGet(tokenApi));
        //获取openid
        String openid = tokenNode.get("openid").asText();
        //获取access_token
        String accessToken = tokenNode.get("access_token").asText();
        //拉取用户信息
        String userinfoApi = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + accessToken +
                "&openid=" + openid +
                "&lang=zh_CN";
        JsonNode userinfoNode = JsonUtil.parse2json(HttpClientUtil.doGet(userinfoApi));
        //页面跳转
        request.setAttribute("nickname", userinfoNode.get("nickname").asText());
        request.setAttribute("avatar", userinfoNode.get("headimgurl").asText());
        request.setAttribute("province", userinfoNode.get("province").asText());
        request.setAttribute("city", userinfoNode.get("city").asText());
        request.setAttribute("openid", openid);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
