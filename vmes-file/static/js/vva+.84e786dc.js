(window.webpackJsonp=window.webpackJsonp||[]).push([["vva+"],{"vva+":function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),o=i("t3Un");function n(e){return Object(o.a)({url:"/sale/saleReceiveRecord/listPageSaleReceiveRecords",method:"post",data:e})}var s=i("z0WU");function l(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){r(e,t,i[t])})}return e}function r(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var c={name:"dialog-option",props:["initData","visible"],data:function(){return{productId:"",dialogTopLoading:!1,isVisible:!1,title:"",topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.productId=this.initData.productId,this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable(!0)},initTable:function(e){var t=this;t.dialogTopLoading=!0,n(l({},t.tempQuery,{customerId:this.initData.temp.id,orderStr:" record.cdate desc ",pageNo:t.pageNo})).then(function(i){t.getListPage(i),e&&(t.dialogTopLoading=!1)}).catch(function(e){console.log(e),t.dialogTopLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(s.k)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var o=e[i];o.indexOf("_")>0&&("en"==a.a.locale?o=o.substring(o.indexOf("_")+1):"zh"==a.a.locale&&(o=o.substring(0,o.indexOf("_")))),t.tempLable[i]=o}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==a.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==a.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.refreshTable()},refreshTable:function(){var e=this;e.$axios.all([n(l({},e.tempQuery,{customerId:this.initData.temp.id,orderStr:" record.cdate desc ",pageNo:e.pageNo}))]).then(e.$axios.spread(function(t){e.getListPage(t)})).catch(function(e){})},dataBridge:function(e){this.selectList=e},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},d=i("KHd+"),g=Object(d.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.title,visible:e.isVisible,"append-to-body":"",width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visibleState},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,isSortable:!1,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1),e._v(" "),i("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);g.options.__file="dialogBalanceList.vue";t.default=g.exports}}]);