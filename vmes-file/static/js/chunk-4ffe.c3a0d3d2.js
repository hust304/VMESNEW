(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4ffe","5BnR"],{"5BnR":function(e,t,i){"use strict";i.r(t);i("91GP"),i("rGqo");var a=i("lX1r"),n=i("uTIz"),o=i("LCER"),s=(i("z0WU"),{name:"dialog-option",props:["initData","visible"],data:function(){return{nextButtonShow:!0,dialogTopLoading:!1,isVisible:!1,title:"",searchConfig:{hideSearchSwitch:!1},searchList:[{label:"订单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单号"},{label:"下单日期起",type:"date",ruleType:"date",mapKey:"orderDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"下单日期止",type:"date",ruleType:"date",mapKey:"orderDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageOrderReceiveDetail","listPageSaleOrderDetail"],expandTableApiParams:[{},{}],tableData:{},initParams:{},updateViewData:{},searchObj:{},childrenData:{},customColumn:{1:[],2:[]},tableSets:{1:{showCheckBox:!0,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},temp:{},tempQuery:{},tempLable:{},selectList:[],pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{expandTable:a.a,searchBar:n.a,dialogReceiptAdd:o.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,"订单收款明细"==this.title?this.nextButtonShow=!1:this.nextButtonShow=!0,this.temp=this.initData.temp,this.initExpandTable()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{nextPage:function(){if(this.selectList.length<=0)this.$message({showClose:!0,message:"请勾选收款费用分摊明细！",duration:5e3});else{var e="";this.selectList.forEach(function(t){e=e?e+",'"+t.id+"'":"'"+t.id+"'"}),this.dialogData.temp=this.temp,this.dialogData.ids=e,this.dialogData.tempLable=this.tempLable,this.dialogData.title="订单结算",this.openDialogName="dialogReceiptAdd",this.showDialog=!0,this.visibleState=!0}},dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState?this.dialogClose():(this.initExpandTable(),this.selectList=[])},initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.initParams,this.currentpage)).then(function(t){e.tableData={row:null,layer:1,res:t,customColumn:e.customColumn},e.$loading().close()}).catch(function(t){console.log(t),e.$loading().close()})},findChildByRow:function(e,t,i,a,n){var o=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,n)).then(function(i){o.childrenData={row:e,layer:t,res:i,customColumn:o.customColumn}}).catch(function(e){console.log(e)})},setParams:function(e,t,i){if(e>1){var a=this.expandTableApiParams[e-1];for(var n in a)a.hasOwnProperty(n)&&(a[n]=t[n]||"");return Object.assign({},a,this.searchObj,{pageNo:i},{parentId:t.id})}return Object.assign({},t,this.searchObj,{pageNo:i},{customerId:this.temp.id})},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.initExpandTable()},databridge:function(e){this.selectList=e}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){}}}),l=i("KHd+"),r=Object(l.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"编辑",visible:e.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visibleState},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("expand-table",{attrs:{initData:e.tableData,childrenData:e.childrenData,configs:e.tableSets,currentpage:e.currentpage,apiObj:{apiName:e.expandTableApiList,apiParams:e.expandTableApiParams},updateViewData:e.updateViewData},on:{"update:currentpage":function(t){e.currentpage=t},databridge:e.databridge,"send-children-row":e.findChildByRow}})],1),e._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:e.nextButtonShow,expression:"nextButtonShow"}],on:{click:e.nextPage}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);r.options.__file="dialogSelectDeliverList.vue";t.default=r.exports},HYdd:function(e,t,i){"use strict";var a=i("lbuq");i.n(a).a},lbuq:function(e,t,i){},qWH3:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rGqo");var a=i("uTIz"),n=i("5BnR"),o=i("mSNy"),s=i("9rC1"),l=(i("5W5M"),i("Vobf")),r=i("z0WU");function c(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){h(e,t,i[t])})}return e}function h(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.viewOrderReceipt_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.viewOrderReceipt(scope.row,scope.$index)">订单收款明细</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},p={data:function(){return{preReceiveAmount:0,nowReceiveAmount:0,guid:"",searchList:[{label:"编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入客户编码"},{label:"名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入客户名称"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{width:400,title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:d,viewOrderReceipt:this.viewOrderReceipt,viewOrderReceipt_isShow:!0}},configs:{topBarBtnList:[{name:"录入收款",nameEn:"add",isShow:!0,icon:"add",method:this.addNew}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:a.a,dialogSelectDeliverList:n.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0)},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.initTable(null)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.refreshTable()},initButtons:function(){var e=this;e.$loading({spinner:"none",text:"智 造 云 管 家"});var t=e.$storage.get("userInfo").roleIds,i=e.$storage.get("menuId");t&&Object(l.initMenuButtons)({menuId:i,roleId:t}).then(function(t){var i=t.buttonList;i&&i.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var i in e.initConfigs.tableOperates)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e.initConfigs.tableOperates[i]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var n=e.customColumn[a];n.length>0&&n.forEach(function(e){if(e)for(var i in e)i.indexOf(t.nameEn)>=0&&i.indexOf("isShow")>0&&(e[i]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(console.log(e),e.isShow=!1)}))})}).catch(function(t){console.log(t),e.$loading().close()})},initTable:function(e){var t=this;Object(s.listPageCustomerReceive)(c({},t.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:t.pageNo})).then(function(i){t.getListPage(i),e&&t.$loading().close()}).catch(function(e){t.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.preReceiveAmount=e.result.preReceiveAmount,this.nowReceiveAmount=e.result.nowReceiveAmount,this.initTempData(e.result.titles);var t=Object(r.k)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==o.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==o.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}}),console.log(t.tempLable)},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==o.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"是否启用"===e.label&&(e.component=stateBtns,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==o.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==o.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},viewOrderReceipt:function(e,t){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="订单收款明细",this.openDialogName="dialogSelectDeliverList",this.showDialog=!0,this.visible=!0},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},refreshTable:function(){var e=this;e.$axios.all([Object(s.listPageCustomerReceive)(c({},e.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:e.pageNo}))]).then(e.$axios.spread(function(t){e.getListPage(t)})).catch(function(e){console.log(e)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},u=(i("HYdd"),i("KHd+")),g=Object(u.a)(p,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"customerManage"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle",attrs:{span:24}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",{attrs:{span:16}},[e._v("  ")]),e._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticStyle:{width:"100%",height:"40px","background-color":"#1482f0","text-align":"center","line-height":"40px",color:"#ffffff"}},[i("span",[e._v("预收款合计：￥"+e._s(e.preReceiveAmount))])])]),e._v(" "),i("el-col",{attrs:{span:4}},[i("div",{staticStyle:{width:"100%",height:"40px","background-color":"#2ED18C","text-align":"center","line-height":"40px",color:"#ffffff"}},[i("span",[e._v("应收款合计："+e._s(e.nowReceiveAmount))])])])],1),e._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);g.options.__file="index.vue";t.default=g.exports}}]);