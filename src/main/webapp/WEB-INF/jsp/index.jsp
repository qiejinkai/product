<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<link rel="stylesheet" type="text/css" href="css/banner.css" />
<link rel="stylesheet" type="text/css" href="css/project_item.css" />
<script type="text/javascript" src="js/jquery.mini.js"></script>
<script type="text/javascript" src="js/jquery.superslide.js"></script>
</head>
<body>
<!--header-->
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<!--header_nav-->

<!--  banner   -->
<div class="slider">
	<ul class="slider_item">
		<li style='background:url(http://equity.eechou.com/image/2015-08-30/735cbd8d546ebdfd4bb524fa9d4fd962.jpg) top center no-repeat;' title="股权众筹，领投加跟投模式，百分之一的投资，成就百分百的创业梦想"><a href="http://qq.com" ></a></li>
		<li style='background:url(http://equity.eechou.com/image/2015-08-30/e299ac043329549b2685ea4d9a78e64f.jpg) top center no-repeat;' title="汇聚创业梦想"><a href="http://top.efunding.cn/" ></a></li>
		<li style='background:url(http://equity.eechou.com/image/2015-09-10/c89018210b5d0d84afb566cae7833b8e.jpg) top center no-repeat;' title="一张图带你了解股权众筹"><a href="http://top.efunding.cn/" ></a></li>
	</ul>
	<!--<div class="slider_box">
		<ul class="slider_index"></ul>
	</div>-->
	<a class="prev"></a>
	<a class="next"></a>
    <span class="pageState"></span>
</div>
<script>
$(".slider").slide({ titCell:".slider_index" , mainCell:".slider_item" , effect:"fold", autoPlay:true, delayTime:700 , autoPage:true });
</script>
<!--  news -->
<div class="news">
	<i></i>
	<span><a>跳舞的犀牛存在欺诈行为，已经入黑名单</a></span><span>/</span>
    <span><a>热烈庆祝私募股权融资平台上线</a></span><span>/</span>
    <span><a>内蒙古万亩油田项目即将上线，出让14%股份分红加实物回报</a></span>
</div>
<!-- count_list -->
<div class="count_list_wrap">
	<div class="count_list">
    	<div class="list_box">
            <div class="count_box">
                <span class="top">已有108个<br>成功90个</span>
                <span class="bottom">众筹项目</span>
            </div>
            <div class="count_box">
                <span class="top top_other">共完成<br>1056564<br>次</span>
                <span class="bottom">支持次数</span>
            </div>
            <div class="count_box">
                <span class="top top_other">已筹集<br>12046464<br>万元</span>
                <span class="bottom">筹集资金</span>
            </div>
            <div class="count_box">
                <span class="top">146765<br>人在此众筹</span>
                <span class="bottom">平台用户</span>
            </div>
        </div>
        
    </div>
</div>
<!--  warp  -->
<div class="warp">
	<!--  标题 -->
    <div class="m_title">
    	<span>热门项目</span><em>已有100000本热门小说在此完成众筹</em><a></a>
    </div>
    <!--  end  -->
    
    <!--  热门项目  -->
    <div class="m_pro_detail">
    	<div class="m_pro_detail_img">
        	<img src="img/img.jpg">
        </div>
        <div class="m_pro_detail_text">
        	<h2>亚洲跨境众筹加快推进大众创业万众创新与投资大会圆满结束一带一路中国企</h2>
            <div class="label_wrap">
            	<i class="sp">众筹中</i>
                <span>发起人：</span><em>易筹精选</em><i class="dian"></i><em>北京朝阳</em><em>互联网金融 / 咖啡 / 创新科技</em>
            </div>
            <p>自年英国人发明电视以来，电视已陪伴我们走过了几十个年头。在中国从上世纪80年代开始直到本世纪初是每个大众家庭的首选娱乐方式。发明电视以来电视已陪伴我们走过了几十个年头在中国从上世纪年代开始直。</p>
            <div class="project_jd">
              <h3>已筹集</h3>
              <h1><span>100000</span><em>￥</em></h1>
              <div class="project_jd_div">
                  <div class="project_jd_bar">
                      <span></span>
                  </div>
                  <em>0%</em>
              </div>
              <div class="numb">
                  <span><em>32</em>天剩余</span>
              </div>
            </div>
        </div>
    </div>
    <div class="m_pro_detail">
    	<div class="m_pro_detail_img">
        	<img src="img/img.jpg">
        </div>
        <div class="m_pro_detail_text">
        	<h2>亚洲跨境众筹加快推进大众创业万众创新与投资大会圆满结束一带一路中国企</h2>
            <div class="label_wrap">
            	<i class="sp">众筹中</i>
                <span>发起人：</span><em>易筹精选</em><i class="dian"></i><em>北京朝阳</em><em>互联网金融 / 咖啡 / 创新科技</em>
            </div>
            <p>自年英国人发明电视以来，电视已陪伴我们走过了几十个年头。在中国从上世纪80年代开始直到本世纪初是每个大众家庭的首选娱乐方式。发明电视以来电视已陪伴我们走过了几十个年头在中国从上世纪年代开始直。</p>
            <div class="project_jd">
              <h3>已筹集</h3>
              <h1><span>100000</span><em>￥</em></h1>
              <div class="project_jd_div">
                  <div class="project_jd_bar">
                      <span></span>
                  </div>
                  <em>0%</em>
              </div>
              <div class="numb">
                  <span><em>32</em>天剩余</span>
              </div>
            </div>
        </div>
    </div>
    <!--  end  -->
    
    <!--  标题 -->
    <div class="m_title">
    	<span>推荐项目</span><em>已有100000本热门小说在此完成众筹</em><a></a>
    </div>
    <!--  end  -->
    
    <!--  推荐项目  -->
    <div class="pro_list_wrap">
    	<div class="pro_list_box">
            <div class="pro_list_img">
                <a><img src="img/img.jpg"></a>
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2><a>你幸福就好苏奕站在他觉得的大门前犹徊</a></h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="pro_list_box">
            <div class="pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--  end  -->
    <!--  标题 -->
    <div class="m_title">
    	<span>成功案例</span><em>已有100000本热门小说在此完成众筹</em><a></a>
    </div>
    <!--  end  -->
    
    <!--  成功案例  -->
    <div class="pro_list_wrap">
    	<div class="succ_pro_list_box">
            <div class="succ_pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="succ_pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <p>她足以让你的客厅成为电影院;她，令电视机成为摆设的机会都丧失;因为，只要她</p>
                <div class="label_wrap">
                	<span>发起人：</span><em>明天出版社</em><i class="dian"></i><em>北京</em><em>文艺/原创/设计师</em>
           	 	</div>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="succ_pro_list_box">
            <div class="succ_pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="succ_pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <p>她足以让你的客厅成为电影院;她，令电视机成为摆设的机会都丧失;因为，只要她</p>
                <div class="label_wrap">
                	<span>发起人：</span><em>明天出版社</em><i class="dian"></i><em>北京</em><em>文艺/原创/设计师</em>
           	 	</div>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="succ_pro_list_box">
            <div class="succ_pro_list_img">
                <img src="img/img.jpg">
                <i class="sp">筹集中</i>
            </div>
            <div class="succ_pro_list_text">
                <h2>你幸福就好苏奕站在他觉得的大门前犹徊</h2>
                <p>她足以让你的客厅成为电影院;她，令电视机成为摆设的机会都丧失;因为，只要她</p>
                <div class="label_wrap">
                	<span>发起人：</span><em>明天出版社</em><i class="dian"></i><em>北京</em><em>文艺/原创/设计师</em>
           	 	</div>
                <div class="pro_list_prosess">
                    <span></span>
                </div>
                <div class="pro_list_bottom">
                    <ul>
                        <li><span><em>100</em><i>%</i></span><span>已完成</span></li>
                        <li><span><em>00000</em><i>￥</i></span><span>已筹集</span></li>
                        <li><span><em>11</em><i>day</i></span><span>剩余</span></li>
                    </ul>
                </div>
            </div>
        </div>
        
    </div>
    <!--  end  -->
    <!--  标题 -->
    <div class="m_title">
    	<span>和阅资讯</span><em>每天都有新鲜的众筹资讯在此传递</em><a></a>
    </div>
    <!--  end  -->
    <!--  和阅资讯  -->
    <div class="home_news">
    	<div class="home_news_item">
        	<div class="home_news_item_t">
            	<div class="home_news_img">
                	<a><img src="img/img.jpg"></a>
                </div>
                <div class="home_news_infos">
                	<h1><a>股权众筹迎来行业洗牌股权众筹迎来行业洗牌</a></h1>
                    
                    <p>日前，证监会新闻发言人邓舸在例行新闻发布会上表示，为规范通过互联网开展股权融资的活动，证监会决定...</p>
					<h2>2015/08/25</h2>
                </div>
            </div>
        </div>
        <div class="home_news_item">
            <div class="home_news_item_t">
                <div class="home_news_img">
                    <a><img src="img/img.jpg"></a>
                </div>
                <div class="home_news_infos">
                    <h1><a>整顿互联网私募股权众筹要“集体改名”</a></h1>
                    
                    <p>日前，证监会发布了《关于对通过互联网开展股权融资活动的机构进行专项检查的通知》消息一出，不少人解读为...</p>
					<h2>2015/08/25</h2>
                </div>
            </div>
        </div>
    </div>	
    <!--  end  -->
    
    <!--  标题 -->
    <div class="m_title">
    	<span>合作伙伴</span><a></a>
    </div>
    <!--  end  -->
    <!--  合作伙伴 -->
    <div class="home_partners">
    	<ul>
            <li><a><img src="img/partner.png" width="100%" height="100%"></a></li>
            <li><a><img src="img/partner.png" width="100%" height="100%"></a></li>
            <li><a><img src="img/partner.png" width="100%" height="100%"></a></li>
            <li><a><img src="img/partner.png" width="100%" height="100%"></a></li>
            <li><a><img src="img/partner.png" width="100%" height="100%"></a></li>
            <li><a><img src="img/partner.png" width="100%" height="100%"></a></li>
        </ul>
    </div>
    <!--  end  -->
    
</div>

<!--footer -->
<div id="footer">
	<div class="footer_nav">
    	<a>关于我们</a>
        <a>新手指引</a>
        <a>合作伙伴</a>
        <a class="last">隐私保护</a>
        <span>浙ICP备15004899号-1  |  咪咕数字传媒有限公司所有</span>    
    </div>
</div>
</body>
</html>
