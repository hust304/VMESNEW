(window.webpackJsonp=window.webpackJsonp||[]).push([["Ix1l"],{Ix1l:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("uTIz"),o=i("2+ib"),s=i("6h4f");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={components:{searchBar:a.a,multilevelTable:o.a,dialogProduct:s.default},name:"dialog-add",props:["initData","visible"],data:function(){return{searchList:[{label:"编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入编码"},{label:"名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入名称"}],guid:"",searchObj:{},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",sourceWarehouseId:"",queryStr:"",title:""},rowTableList:[],tableConfigList:[{apiObj:{apiName:"listPageWarehouse",params:{isNotNeedSpare:"true",isNeedWarehouseProduct:"true",isNeedEntity:"true"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,isSingle:!0,componentId:"oneLevelTable"}]}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(e)},databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){(e={}).resState=this.resState,this.$emit("close-dialog",e||{})},updateData:function(e){this.$refs.customBaseTable.updateData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},closeDialog:function(e){e.resState&&(this.resState=e.resState),this.isVisible=!1},save:function(){var e="";if(null!=this.rowTableList&&0!=this.rowTableList.length||(e="请选择一行数据！"),e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var t=this.rowTableList[0].id;this.dialogData.queryStr="prod.id in (select wp.product_id from vmes_warehouse_product wp left join vmes_warehouse w on wp.warehouse_id = w.id where w.warehouse_id = '"+t+"' group by wp.product_id)",this.dialogData.sourceWarehouseId=t,this.dialogData.title="选择货品",this.openDialogName="dialogProduct",this.showDialog=!0,this.inLinVisible=!0}}}},r=i("KHd+"),d=Object(r.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{style:e.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_warehouseByWC_moveByWC_dialogWarehouse0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("下一步")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)},[],!1,null,null,null);d.options.__file="dialogWarehouse.vue";t.default=d.exports}}]);