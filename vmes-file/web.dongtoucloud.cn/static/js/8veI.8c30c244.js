(window.webpackJsonp=window.webpackJsonp||[]).push([["8veI"],{"8veI":function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var n=i("rwyD"),o=i("AUoE"),a=i("z0WU"),l=i("mSNy");function r(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.orderDtlDeliverCount" @change="colConfig.orderDtlDeliverCountChange(scope.row,scope.$index)"/>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.deliverDtlRemark" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{priceType:"1",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0},pageData:null,pageNo:1,resState:null}},created:function(){var e=this.initData.orderDtlIds;this.initTable(!0,e)},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=s(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(a.l)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var n=e[i];n.indexOf("_")>0&&("en"==l.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==l.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[i]=n}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var i=e.label;i.indexOf("_")>0&&("en"==l.a.locale?e.label=i.substring(i.indexOf("_")+1):"zh"==l.a.locale&&(e.label=i.substring(0,i.indexOf("_")))),"orderDtlDeliverCount"===e.prop?(e.component=c,e.orderDtlDeliverCountChange=t.orderDtlDeliverCountChange):"deliverDtlRemark"===e.prop&&(e.component=u)}),e},initTable:function(e,t){var i=this;e&&(this.BaseTableLoading=!0),Object(n.listPageOrderDetailQueryByDeliver)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),n.forEach(function(t){r(e,t,i[t])})}return e}({},this.tempQuery,{fieldCode:"productCode,productName,productSpec,orderUnitName,orderCount,productStockCount,notDeliverCount,orderDtlDeliverCount,productPrice,productSum,deliverDtlRemark",ids:t,pageNo:this.pageNo})).then(function(t){i.getListPage(t),i.dialogLoading=!1,e&&(i.BaseTableLoading=!1)}).catch(function(e){i.dialogLoading=!1,i.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},dataBridge:function(e){},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(e.trim())},orderDtlDeliverCountChange:function(e,t){e.notDeliverCount;var i=e.orderDtlDeliverCount,n=e.productPrice;null!=n&&n.trim().length>0&&(e.productSum=(i.trim()*n.trim()).toFixed(2))},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var n=e[i],o=n.notDeliverCount,a=n.orderDtlDeliverCount;null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())?t=t+"第 "+(i+1)+" 行: 请输入大于零的正整数或(1,2)位小数！":((a=(a+"").trim())<=0&&(t=t+"第 "+(i+1)+" 行: 本次发货数量必须大于零！"),a-o>0&&(t=t+"第 "+(i+1)+" 行: 本次发货数量不可大于未发货数量！"))}return t},saveSaleDeliver:function(){var e=this,t=this.tableData;if(null!=t&&0!=t.length){var i=this.checkColumn(t);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var n=[];t.forEach(function(e){n.push(e)});var a=JSON.stringify(n);Object(o.addSaleDeliver)({roleId:this.$storage.get("userInfo").roleIds,priceType:this.priceType,dtlJsonStr:a}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})}}},g=i("KHd+"),p=Object(g.a)(d,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{padding:"10px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.saveSaleDeliver}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogAddDeliverDetail.vue";t.default=p.exports}}]);