(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-299a"],{"+l0W":function(e,t,a){},KxAj:function(e,t,a){"use strict";var i=a("+l0W");a.n(i).a},YPSH:function(e,t,a){"use strict";a.r(t);var i=a("f/WR"),s=a("uTIz"),l=a("NaOS"),n={name:"encapsulation",components:{transferTable:i.a,DynaForm:l.a,searchBar:s.a},data:function(){return{userInfo:null,isVisible:!1,showDialog:!1,guid:"",btnList:[{name:"生成盘点任务",isShow:!0,state:!0,method:this.addMenu},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageLogInfo",params:{}},tableSelectList:[],stateBtnData:{title:"上次盘点至今变动过的货品"},tableConfigs:{showIndex:!0,isSingle:!1,isSortable:!1},formTemp:[{key:"haha",value:"sde"}],searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"货品总金额",type:"select",mapKey:"totalAmount",configs:{clearable:!0,name:"",options:[{value:1,label:"从低到高"},{value:2,label:"从高到低"}]},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"},{label:"货品单价",type:"magnifier",mapKey:"magnifier",configs:{dialogType:"table",apiName:"listPageRoles",params:{}},placeholder:"请选择"}],searchMethod:{},searchConfig:{}}},created:function(){this.userInfo=this.$storage.get("userInfo")},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},methods:{changeRoleState:function(e,t){},testBtn:function(e,t){},editRole:function(e,t){},getList:function(){this.$refs.dynaForm.getFormList()},formListResult:function(e){},searchMap:function(e){},searchRes:function(e){},sendGuid:function(e){this.guid=e},dialogBtns:function(){this.showDialog=!0,this.isVisible=!0},addMenu:function(){},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(e){this.tableSelectList=e}}},o=(a("KxAj"),a("KHd+")),r=Object(o.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"testPage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchMethod:e.searchMethod,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"search-res":e.searchRes,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[a("div",{staticStyle:{float:"left",width:"210px",height:"100%"}}),e._v(" "),a("div",{staticStyle:{float:"left",width:"calc(100% - 210px)",height:"100%"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:e.tableConfigs,btnList:e.btnList,stateBtn:e.stateBtnData,apiData:e.apiData},on:{"table-selected":e.tableSelected}})],1)])],1)},[],!1,null,null,null);r.options.__file="index.vue";t.default=r.exports}}]);