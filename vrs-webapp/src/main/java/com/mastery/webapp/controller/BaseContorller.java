package com.mastery.webapp.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;
import com.mastery.common.Constant;
import com.mastery.common.PagingUtil.PagingVO;
import com.mastery.data.base.BaseVo;
import com.mastery.model.Channel;

/**
 * base controller
 * 
 * @author zouziwen 
 */
public abstract class BaseContorller {
    
    private final Logger logger  = LoggerFactory.getLogger(this.getClass());
    
	/**
	 * 定向到错误页面
	 * 
	 * @return view
	 */
	public String toErrorPage() {
		return "/error";
	}
	
	@SuppressWarnings("unchecked")
	protected List<Channel> getChannels(HttpServletRequest request) {
		return (List<Channel>) request.getSession().getAttribute("channelList");
	}

	protected Channel getChannel(HttpServletRequest request , Long cid) {
		List<Channel> channels = getChannels(request);
		for(Channel channel : channels) {
			if(channel.getId().equals(cid)) {
				return channel;
			}
		}
		return null;
	}
	
	protected void setPage(BaseVo vo , Map<String, Object> map) {
		PagingVO pageVo = vo.getPageVo();
		map.put("recordCount", pageVo.getRecordCount()); // 总记录数
		map.put("pageNum", pageVo.getPageNum()); // 第几页
		map.put("pageCount", pageVo.getPageCount()); // 总页数
		map.put("numPerPage", pageVo.getNumPerPage()); // 每页记录数
		map.put("pageBegin", pageVo.getPageBegin()); // 显示页码开始
		map.put("pageEnd", pageVo.getPageEnd()); // 显示页码范围结束
	}
	
	/**
	 * 定向到错误页面
	 * 
	 * @param msg 错误消息
	 * @param model ModelMap
	 * @return view
	 */
	public String toErrorPage(String msg, ModelMap model) {
		model.addAttribute("ERROR_MSG", msg);
		return this.toErrorPage();
	}
	
    /**
     * 输出JSON数据
     * 
     * @param obj
     * @param request
     * @param response
     */
    protected void printJSON(Object obj, HttpServletRequest request, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            String jsoncallback = request.getParameter("jsoncallback");
            // 替换单引号 否则suggest带回，html解析有问题
            String filterResult =
                            JSON.toJSONString(obj).replaceAll(Constant.SINGLE_QUOTES,
                                            Constant.QUOTES_TRANSLATION);
            if (null == jsoncallback || jsoncallback.isEmpty()) {
                writer.print(filterResult);
            } else {
                writer.print(jsoncallback + Constant.LEFT_BRACE + filterResult
                                + Constant.RIGHT_BRACE);
            }
        } catch (Exception e) {
            logger.error("输出信息失败！" + e.getMessage());
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    /**
     * 向页面输出信息
     * 
     * @param info
     * @param response
     */
    protected void writeInfo(String info, HttpServletResponse response) {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(info);
        } catch (Exception e) {
            logger.error("输出信息失败！" + e.getMessage());
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

}
