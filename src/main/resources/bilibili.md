
1.aid(id)、view(观看次数)、danmaku(总弹幕数)、reply(弹幕数)、his_rank(最高全站日排行)、favorite(收藏人数)、coin(硬币数)、share(分享数)

https://api.bilibili.com/x/web-interface/archive/stat?callback=jQuery17208549602856317029_1502097590081&aid=4964006&jsonp=jsonp&_=1502097590829

{"code":0,"data":{"aid":4964006,"view":239541,"danmaku":9649,"reply":9649,"favorite":4871,"coin":3146,"share":659,"now_rank":0,"his_rank":65,"no_reprint":0,"copyright":1},"message":"0","ttl":1}

2.充电用户
https://api.bilibili.com/x/elec/show?callback=jQuery17203647504075384749_1502160625440&aid=4964006&jsonp=jsonp&_=1502160625810

{"code":0,"data":{"show":true,"state":0,"total":559,"count":2,"list":[{"mid":3334179,"pay_mid":3161824,"rank":1,"uname":"清风拂柳雨烟岚","avatar":"http://i1.hdslb.com/bfs/face/a886719c08b2275b2a0c7a025b871f76c7661593.jpg","vip_info":{"vipType":1,"vipDueMsec":23373134017,"vipStatus":0},"trend_type":0},{"mid":3334179,"pay_mid":17633577,"rank":2,"uname":"轰焦冻土层","avatar":"http://i2.hdslb.com/bfs/face/db4dca83389c710c4077e41a56bc1d33989b14e0.jpg","vip_info":{"vipType":0,"vipStatus":0},"trend_type":1}],"user":null}}

3.视频
https://interface.bilibili.com/player?id=cid:8062397&aid=4964006
<ip>180.173.22.211</ip>
<zoneip></zoneip>
<zoneid>4308992</zoneid>
<country>中国</country>
<login>false</login>
<time>1502161488</time>
<lastplaytime>0</lastplaytime>
<lastcid>0</lastcid>
<aid>4964006</aid>
<typeid>76</typeid>
<vtype>vupload</vtype>
<oriurl></oriurl>
<suggest_comment>false</suggest_comment>
<server>chat.bilibili.com</server>
<maxlimit>3000</maxlimit>
<click>239551</click>
<fw_click>1884</fw_click>
<chatid>8062397</chatid>
<pid>1</pid>
<duration>29:35</duration>
<arctype>Original</arctype>
<allow_bp>false</allow_bp>
<bottom>0</bottom>
<shot>false</shot>
<sinapi>1</sinapi>
<acceptguest>false</acceptguest>
<acceptaccel>false</acceptaccel>
<cache>false</cache>
<broadcast_tcp>broadcast.chat.bilibili.com:4080</broadcast_tcp>
<broadcast_ws>broadcast.chat.bilibili.com:4090</broadcast_ws>
<broadcast_wss>broadcast.chat.bilibili.com:4095</broadcast_wss>
<default_dm>0</default_dm>
<dm_host>0://comment.bilibili.com,1://comment.bilibili.com/rc</dm_host>
<role>0</role>
<has_next>0</has_next>
<new_broadcast>1</new_broadcast>
<realtime_dm>1</realtime_dm>

4.up主信息
https://api.bilibili.com/cardrich?&callback=jQuery172032227386959300364_1502170082763&mid=3334179&type=jsonp&_=1502170083228
{
  "code": 0,
  "data": {
    "card": {
      "mid": "3334179",
      "name": "\u6211\u7684\u6837\u5b50\u5e73\u5e73\u65e0\u5947",
      "approve": false,
      "sex": "\u4fdd\u5bc6",
      "rank": "10000",
      "face": "http:\/\/i0.hdslb.com\/bfs\/face\/2d0e7a13462effe3a5e80d774ea0c48be4c9ce47.jpg",
      "DisplayRank": "10000",
      "regtime": 1392281007,
      "spacesta": 0,
      "birthday": "1980-01-01",
      "place": "\u5317\u4eac\u5e02 \u6d77\u6dc0\u533a",
      "description": "",
      "article": 0,
      "attentions": [
        97503781,
        22337995,
        34149649,
        1965656,
        1590653,
        30110952,
        36296254,
        67172607,
        123938419,
        3766866,
        1605721,
        117693,
        3301665,
        4987418,
        185546,
        1643718,
        2929048,
        3068895,
        1556033,
        486183,
        8554424,
        916623,
        322892,
        288239
      ],
      "fans": 515525,
      "friend": 24,
      "attention": 24,
      "sign": "\u6c61\u5996\u738b\uff0c\u4e13\u4e1a\u758f\u901a\u4e0b\u6c34\u9053 \u3002\u5fae\u535a\uff1a\u6211\u7684\u6837\u5b50\u5e73\u5e73\u65e0\u5947",
      "level_info": {
        "current_level": 6,
        "current_min": 28800,
        "current_exp": 347734,
        "next_exp": "-"
      },
      "pendant": {
        "pid": 0,
        "name": "",
        "image": "",
        "expire": 0
      },
      "nameplate": {
        "nid": 0,
        "name": "",
        "image": "",
        "image_small": "",
        "level": "",
        "condition": ""
      },
      "official_verify": {
        "type": -1,
        "desc": ""
      },
      "vip": {
        "vipType": 0,
        "vipDueDate": 0,
        "dueRemark": "",
        "accessStatus": 1,
        "vipStatus": 0,
        "vipStatusWarn": ""
      }
    },
    "space": {
      "s_img": "http:\/\/i0.hdslb.com\/bfs\/space\/718eac8c71e29b8a80431c46110805c3a40e30a6.jpg",
      "l_img": "http:\/\/i0.hdslb.com\/bfs\/space\/70ce28bcbcb4b7d0b4f644b6f082d63a702653c1.png"
    }
  },
  "message": "0",
  "ttl": 1
}

5.历史充电人数
https://elec.bilibili.com/web/rank/query/av?callback=jQuery172032227386959300364_1502170082770&mid=3334179&av_no=4964006&type=jsonp&_=1502170083582
jQuery172032227386959300364_1502170082770({"code":0,"data":{"count":0,"av_count":0,"total_count":559,"list":[],"special_day":0}})

6.回复数
https://api.bilibili.com/x/v2/reply?callback=jQuery172032227386959300364_1502170082782&jsonp=jsonp&pn=1&type=1&oid=4964006&sort=0&_=1502170924829
data.data.page.acount