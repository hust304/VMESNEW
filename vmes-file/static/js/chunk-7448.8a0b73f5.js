(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7448","chunk-6cf6","chunk-4305","vva+","3RIN","5BnR"],{"3RIN":function(t,e,i){"use strict";i.r(e);i("91GP");var a=i("lX1r"),n=i("uTIz"),o=(i("z0WU"),{name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",searchConfig:{hideSearchSwitch:!1},searchList:[{label:"收款单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入收款单号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入客户名称"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleReceives","listPageSaleReceiveDetails"],expandTableApiParams:[{},{}],tableData:{},initParams:{},updateViewData:{},searchObj:{},childrenData:{},customColumn:{1:[],2:[]},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!0,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},temp:{},tempQuery:{},tempLable:{},selectList:[],pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{expandTable:a.a,searchBar:n.a},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,this.initExpandTable()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},initExpandTable:function(){var t=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.initParams,this.currentpage)).then(function(e){t.tableData={row:null,layer:1,res:e,customColumn:t.customColumn},t.$loading().close()}).catch(function(e){t.$loading().close()})},findChildByRow:function(t,e,i,a,n){var o=this;this.$api[this.expandTableApiList[e-1]](this.setParams(e,t,n)).then(function(i){o.childrenData={row:t,layer:e,res:i,customColumn:o.customColumn}}).catch(function(t){})},setParams:function(t,e,i){if(t>1){var a=this.expandTableApiParams[t-1];for(var n in a)a.hasOwnProperty(n)&&(a[n]=e[n]||"");return Object.assign({},a,this.searchObj,{pageNo:i},{parentId:e.id})}return Object.assign({},e,this.searchObj,{pageNo:i},{customerId:this.temp.id})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.initExpandTable()},databridge:function(t){this.selectList=t}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){}}}),s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("expand-table",{attrs:{initData:t.tableData,childrenData:t.childrenData,configs:t.tableSets,currentpage:t.currentpage,apiObj:{apiName:t.expandTableApiList,apiParams:t.expandTableApiParams},updateViewData:t.updateViewData},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.databridge,"send-children-row":t.findChildByRow}})],1),t._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);l.options.__file="dialogReceiptList.vue";e.default=l.exports},"5BnR":function(t,e,i){"use strict";i.r(e);i("91GP"),i("rGqo");var a=i("lX1r"),n=i("uTIz"),o=i("LCER"),s=(i("z0WU"),{name:"dialog-option",props:["initData","visible"],data:function(){return{nextButtonShow:!0,dialogTopLoading:!1,isVisible:!1,title:"",searchConfig:{hideSearchSwitch:!1},searchList:[{label:"订单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单号"},{label:"下单日期起",type:"date",ruleType:"date",mapKey:"orderDateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"下单日期止",type:"date",ruleType:"date",mapKey:"orderDateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageOrderReceiveDetail","listPageSaleOrderDetail"],expandTableApiParams:[{},{}],tableData:{},initParams:{},updateViewData:{},searchObj:{},childrenData:{},customColumn:{1:[],2:[]},tableSets:{1:{showCheckBox:!0,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},temp:{},tempQuery:{},tempLable:{},selectList:[],pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{expandTable:a.a,searchBar:n.a,dialogReceiptAdd:o.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,"订单收款明细"==this.title?this.nextButtonShow=!1:this.nextButtonShow=!0,this.temp=this.initData.temp,this.initExpandTable()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{nextPage:function(){if(this.selectList.length<=0)this.$message({showClose:!0,message:"请勾选收款费用分摊明细！",duration:5e3});else{var t="";this.selectList.forEach(function(e){t=t?t+",'"+e.id+"'":"'"+e.id+"'"}),this.dialogData.temp=this.temp,this.dialogData.ids=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="订单结算",this.openDialogName="dialogReceiptAdd",this.showDialog=!0,this.visibleState=!0}},dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState?this.dialogClose():(this.initExpandTable(),this.selectList=[])},initExpandTable:function(){var t=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.initParams,this.currentpage)).then(function(e){t.tableData={row:null,layer:1,res:e,customColumn:t.customColumn},t.$loading().close()}).catch(function(e){t.$loading().close()})},findChildByRow:function(t,e,i,a,n){var o=this;this.$api[this.expandTableApiList[e-1]](this.setParams(e,t,n)).then(function(i){o.childrenData={row:t,layer:e,res:i,customColumn:o.customColumn}}).catch(function(t){})},setParams:function(t,e,i){if(t>1){var a=this.expandTableApiParams[t-1];for(var n in a)a.hasOwnProperty(n)&&(a[n]=e[n]||"");return Object.assign({},a,this.searchObj,{pageNo:i},{parentId:e.id})}return Object.assign({},e,this.searchObj,{pageNo:i},{customerId:this.temp.id})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.initExpandTable()},databridge:function(t){this.selectList=t}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){}}}),l=i("KHd+"),r=Object(l.a)(s,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("expand-table",{attrs:{initData:t.tableData,childrenData:t.childrenData,configs:t.tableSets,currentpage:t.currentpage,apiObj:{apiName:t.expandTableApiList,apiParams:t.expandTableApiParams},updateViewData:t.updateViewData},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.databridge,"send-children-row":t.findChildByRow}})],1),t._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{directives:[{name:"show",rawName:"v-show",value:t.nextButtonShow,expression:"nextButtonShow"}],on:{click:t.nextPage}},[t._v("下一步")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);r.options.__file="dialogSelectDeliverList.vue";e.default=r.exports},Bti9:function(t,e,i){},Bzc8:function(t,e,i){"use strict";var a=i("Bti9");i.n(a).a},Ecqr:function(t,e,i){},PDJX:function(t,e,i){"use strict";var a=i("Ecqr");i.n(a).a},RaAm:function(t,e,i){"use strict";var a=i("x9fT");i.n(a).a},Rmuu:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("uTIz"),n=i("y6BG"),o=i("vva+"),s=i("xQ+D"),l=i("5BnR"),r=i("3RIN"),c=i("mSNy"),d=i("9rC1"),p=(i("5W5M"),i("Vobf")),h=i("z0WU");function u(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){g(t,e,i[e])})}return t}function g(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.shareAmount_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.shareAmount(scope.row,scope.$index)">分摊预收款</el-button>\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.viewReceipt_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.viewReceipt(scope.row,scope.$index)">查看收款单</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.receiptDetail_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.receiptDetail(scope.row,scope.$index)">收款明细</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editReceipt_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editReceipt(scope.row,scope.$index)">更正预收款</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},m={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},b={data:function(){return{guid:"",searchList:[{label:"客户编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入客户编码"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入客户名称"},{label:"客户类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入客户类型"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{width:400,title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:f,shareAmount:this.shareAmount,shareAmount_isShow:!0,viewReceipt:this.viewReceipt,viewReceipt_isShow:!0,receiptDetail:this.receiptDetail,receiptDetail_isShow:!0,editReceipt:this.editReceipt,editReceipt_isShow:!0}},configs:{topBarBtnList:[{name:"录入收款",nameEn:"add",isShow:!0,icon:"add",method:this.addNew}],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!0},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:a.a,dialogBalanceEdit:n.default,dialogBalanceList:o.default,dialogBalanceAdd:s.default,dialogSelectDeliverList:l.default,dialogReceiptList:r.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0)},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.initTable(null)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(p.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var a in t.customColumn)if(a){var n=t.customColumn[a];n.length>0&&n.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},initTable:function(t){var e=this;Object(d.listPageCustomerReceive)(u({},e.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&e.$loading().close()}).catch(function(t){e.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(h.k)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==c.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==c.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==c.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==c.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=m,t.changeState=e.changeState)}),e.internationalConfig(),t.push(e.initConfigs.tableOperates),t},internationalConfig:function(){"en"==c.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==c.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},editReceipt:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="调整预收款",this.openDialogName="dialogBalanceEdit",this.showDialog=!0,this.visible=!0},viewReceipt:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="收款单",this.openDialogName="dialogReceiptList",this.showDialog=!0,this.visible=!0},receiptDetail:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="收款明细",this.openDialogName="dialogBalanceList",this.showDialog=!0,this.visible=!0},shareAmount:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.temp.balance<=0?this.$message({showClose:!0,message:"预收款金额必须大于零！",duration:5e3}):(this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="分摊预收款",this.openDialogName="dialogSelectDeliverList",this.showDialog=!0,this.visible=!0)},addNew:function(){this.resetTemp(),this.selectList&&0!=this.selectList.length?(this.dialogData.temp=this.selectList[0],this.dialogData.tempLable=this.tempLable,this.dialogData.title="录入收款",this.openDialogName="dialogBalanceAdd",this.showDialog=!0,this.visible=!0):this.$message({showClose:!0,message:"请先选择客户！",duration:5e3})},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},refreshTable:function(){var t=this;t.$axios.all([Object(d.listPageCustomerReceive)(u({},t.tempQuery,{genre:"df7cb67fca4148bc9632c908e4a7fdea",pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},v=(i("PDJX"),i("KHd+")),D=Object(v.a)(b,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"customerManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle",attrs:{span:24}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo,isSingle:t.configs.isSingle},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);D.options.__file="index.vue";e.default=D.exports},"vva+":function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),n=i("t3Un");function o(t){return Object(n.a)({url:"/sale/saleReceiveRecord/listPageSaleReceiveRecords",method:"post",data:t})}var s=i("z0WU");function l(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){r(t,e,i[e])})}return t}function r(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var c={name:"dialog-option",props:["initData","visible"],data:function(){return{productId:"",dialogTopLoading:!1,isVisible:!1,title:"",topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.productId=this.initData.productId,this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable(!0)},initTable:function(t){var e=this;e.dialogTopLoading=!0,o(l({},e.tempQuery,{customerId:this.initData.temp.id,orderStr:" record.cdate desc ",pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&(e.dialogTopLoading=!1)}).catch(function(t){e.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(s.k)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==a.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==a.a.locale&&(t.label=e.substring(0,e.indexOf("_"))))}),t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},refreshTable:function(){var t=this;t.$axios.all([o(l({},t.tempQuery,{customerId:this.initData.temp.id,orderStr:" record.cdate desc ",pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},d=i("KHd+"),p=Object(d.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,isSortable:!1,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);p.options.__file="dialogBalanceList.vue";e.default=p.exports},x9fT:function(t,e,i){},"xQ+D":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("f3/d");var a=i("9rC1");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{code:"",name:"",addBalance:""},tempLable:{},tempNotEditable:{},rules:{},openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{dialogSelectDeliverList:i("5BnR").default},created:function(){this.initData.temp&&(this.temp.id=this.initData.temp.id,this.temp.code=this.initData.temp.code,this.temp.name=this.initData.temp.name,this.temp.addBalance=0),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{nextPage:function(){this.temp.addBalance<=0?this.$message({showClose:!0,message:"收款金额必须大于零！",duration:5e3}):(this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="收款",this.openDialogName="dialogSelectDeliverList",this.showDialog=!0,this.visibleState=!0)},closeDialog:function(t){this.showDialog=!1,this.isVisible=!1,"ok"===t.resState&&this.dialogClose({resState:"ok"})},dialogClose:function(t){this.$emit("close-dialog",t||{})},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},save:function(){var t=this;t.temp.addBalance<=0?this.$message({showClose:!0,message:"收款金额必须大于零！",duration:5e3}):t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.addCustomerBalance)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},s=(i("RaAm"),i("KHd+")),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.dialogWidth},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.openDialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"客户编码:",prop:"code"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.code,callback:function(e){t.$set(t.temp,"code",e)},expression:"temp.code"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"客户名称:",prop:"name"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"收款金额:",prop:"addBalance"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.addBalance,callback:function(e){t.$set(t.temp,"addBalance",t._n(e))},expression:"temp.addBalance"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:t.nextPage}},[t._v("下一步")])],1)],1)],1)},[],!1,null,"15de7710",null);l.options.__file="dialogBalanceAdd.vue";e.default=l.exports},y6BG:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("9rC1");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.beforeBalance=this.temp.balance),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.updateCustomerBalance)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},s=(i("Bzc8"),i("KHd+")),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.dialogWidth},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"调整前预收款:",prop:"beforeBalance"}},[i("el-input",{staticStyle:{width:"140px"},attrs:{disabled:!0},model:{value:t.temp.beforeBalance,callback:function(e){t.$set(t.temp,"beforeBalance",e)},expression:"temp.beforeBalance"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"调整后预收款:",prop:"afterBalance"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.balance,callback:function(e){t.$set(t.temp,"balance",t._n(e))},expression:"temp.balance"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"62687234",null);l.options.__file="dialogBalanceEdit.vue";e.default=l.exports}}]);