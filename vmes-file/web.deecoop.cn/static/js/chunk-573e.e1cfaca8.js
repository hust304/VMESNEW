(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-573e"],{"0Koe":function(e,t,a){},MCfF:function(e,t,a){"use strict";var l=a("0Koe");a.n(l).a},vpHr:function(e,t,a){"use strict";a.r(t);a("91GP");var l=a("varj"),n=a("uTIz"),o={name:"encapsulation",components:{customTransferTable:l.a,searchBar:n.a},data:function(){return{userInfo:null,guid:"",btnList:[{name:"生成盘点任务",isShow:!0,state:!0,method:this.addMenu},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],stateBtnData:{title:"上次盘点至今变动过的货品"},aboveTableConfig:{apiObj:{apiName:"listPageLogInfo",params:{}},customColumn:[{columnIndex:"userCode",width:200,componentName:"input",_cellConfig:{rules:[{required:!0}],message:["必填"],icon:"search"}},{columnIndex:"cdate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd"}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"新增",nameEn:"add",editBtns_isShow:!0,method:this.reviseData},{name:"删除1",nameEn:"delete1",editBtns_isShow:!0,rowState:"#self@count#===10",method:this.deleteAllRow},{name:"删除2",nameEn:"delete2",editBtns_isShow:!0,rowState:"#self@count#===9",method:this.deleteAllRow},{name:"删除3",nameEn:"delete3",editBtns_isShow:!0,method:this.deleteAllRow}]}],tempData:{count:100,defaultDate:"2019-01-21"},showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,leftFixed:2,rightFixed:1,sortableConfig:{"default-sort":{prop:"count",order:"descending"},progress:{},count:{}},dragTable:!1,entireRowDrag:!1},belowTableConfig:{customColumn:[{columnIndex:"operateUrl",width:200,componentName:"input",_cellConfig:{rules:[{required:!0}],message:["必填"],icon:"search"}},{columnIndex:"cdate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd"}},{columnIndex:"userName",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}]}}],tempData:{count:100,defaultDate:"2019-01-21"},showIndex:!0,showCheckBox:!1,leftFixed:2,rightFixed:1,dragTable:!0,entireRowDrag:!1},addColumns:[{columnIndex:5,prop:"userCode1",label:"操作人账号1",componentName:"cascader",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}]}}],hideColumns:["operate"],tableSelectList:[],searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"货品总金额",type:"select",mapKey:"totalAmount",configs:{clearable:!0,name:"",options:[{value:1,label:"从低到高"},{value:2,label:"从高到低"}]},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"},{label:"货品单价",type:"magnifier",mapKey:"magnifier",configs:{dialogType:"table",apiName:"listPageRoles",params:{}},placeholder:"请选择"}]}},created:function(){this.userInfo=this.$storage.get("userInfo")},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},methods:{changeRoleState:function(e,t){},testBtn:function(e,t){},editRole:function(e,t){},searchMap:function(e){this.aboveTableConfig.apiObj.params=Object.assign({},this.aboveTableConfig.apiObj.params,e),this.belowTableConfig.apiObj&&this.belowTableConfig.apiObj.params&&(this.belowTableConfig.apiObj.params=Object.assign({},this.belowTableConfig.apiObj.params,e))},sendGuid:function(e){this.guid=e},tableSelected:function(e){this.tableSelectList=e},addMenu:function(){this.$refs.trabsferTables.getTableSelected()},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()}}},i=(a("MCfF"),a("KHd+")),s=Object(i.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"customTransferTableDemo"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[a("div",{staticStyle:{height:"100%"}},[a("custom-transfer-table",{ref:"trabsferTables",attrs:{aboveTableConfig:e.aboveTableConfig,belowTableConfig:e.belowTableConfig,deDuplication:!1,addColumns:e.addColumns,hideColumns:e.hideColumns,btnList:e.btnList,stateBtn:e.stateBtnData},on:{"table-selected":e.tableSelected}})],1)])],1)},[],!1,null,null,null);s.options.__file="index.vue";t.default=s.exports}}]);