(window.webpackJsonp=window.webpackJsonp||[]).push([["zqqv"],{zqqv:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var n=i("we3T"),a=i("2SRW"),o=i("z0WU"),l=i("mSNy");function s(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.count"/>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.remark" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{dtlIds:"",isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",temp:null,tempLable:null},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.dtlIds="",null!=this.initData.temp.dtlIds&&this.initData.temp.dtlIds.trim().length>0&&(this.dtlIds=this.initData.temp.dtlIds.trim()),this.initTable(!0)},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==l.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==l.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==l.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==l.a.locale&&(t.label=e.substring(0,e.indexOf("_")))),"count"===t.prop&&(t.component=c),"remark"===t.prop&&(t.component=u)}),t},initTable:function(t){var e=this;t&&(this.BaseTableLoading=!0);var i="";null!=this.dtlIds&&this.dtlIds.trim().length>0&&(i="detail.id in ("+this.dtlIds+")"),Object(n.findListByWarehouseCheckExecutor)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){s(t,e,i[e])})}return t}({},this.tempQuery,{detailState:"1",queryStr:i,pageNo:this.pageNo})).then(function(i){e.getListPage(i),t&&(e.BaseTableLoading=!1)}).catch(function(t){e.BaseTableLoading=!1})},dataBridge:function(t){},checkColumnExecuteArray:function(t){var e="";if(null==t||0==t.length)return e="请填写盘点信息！";for(var i=0;i<t.length;i++){var n=t[i];if(null!=n.parentId&&0!=n.parentId.trim().length||(e=e+"第 "+(i+1)+" 行: (盘点单id)为空或空字符串;"),null!=n.detailId&&0!=n.detailId.trim().length||(e=e+"第 "+(i+1)+" 行: (明细id)为空或空字符串;"),null==n.count||0==n.count.trim().length)e=e+"第 "+(i+1)+" 行: (盘点数量)为空或空字符串，(盘点数量)为必填项不可为空;";else{var a=n.count.trim();new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(a)||(e=e+"第 "+(i+1)+" 行: 盘点数量("+n.count.trim()+")输入错误，请输入大于零的正整数或(1,2)位小数！")}}return e},addExecute:function(){var t=this,e=this.tableData,i=this.checkColumnExecuteArray(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var n=[];null!=e&&e.length>0&&e.forEach(function(t){var e={parentId:"",detailId:"",count:"",remark:""};e.parentId=t.parentId,e.detailId=t.detailId,e.count=t.count,null!=t.remark&&t.remark.trim().length>0&&(e.remark=t.remark.trim()),n.push(e)});var o=JSON.stringify(n);Object(a.addWarehouseCheckExecute)({addExecuteJsonStr:o}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})}},closeDialog:function(t){this.showDialog=!1}}},g=i("KHd+"),p=Object(g.a)(d,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("el-row",[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.addExecute}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)},[],!1,null,null,null);p.options.__file="dialogAddByExecute.vue";e.default=p.exports}}]);