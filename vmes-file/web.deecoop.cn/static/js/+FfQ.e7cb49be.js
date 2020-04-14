(window.webpackJsonp=window.webpackJsonp||[]).push([["+FfQ"],{"+FfQ":function(e,t,i){"use strict";i.r(t);var o=i("WIyV"),r=i("3LyK"),a={components:{customBaseTable:o.a},props:["initData","visible"],data:function(){var e=this;return{rules:{receiptTypeName:[{required:!0,trigger:"change",validator:function(t,i,o){e.temp.receiptType.length<=0?o(new Error("请选择发票类型")):o()}}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{orderId:"",receiptTypeBefore:"",receiptTypeAfter:""},tableData:[],orderDtlList:[],apiObj:{apiName:"listPageOrderDetaiByChange",params:{fieldCode:"prodInfo,orderUnitName,orderCount,deliverCount,retreatCount,miniChangeCount,newOrderCount,newProductPrice,productSum,newDeliverDate",addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"productCode,productName,productSpec,productProperty",parentId:"",queryState:"'2','3','4'",isOrderChange:"0"}},customColumn:[{columnIndex:"prodInfo",width:"200",_cellConfig:{hideTitle:!0}},{columnIndex:"newOrderCount",width:"130",componentName:"input",_cellConfig:{rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"},{greaterThan:["self@miniChangeCount",!0]}],message:["此项不能为空！","请输入大于零的整数或(1,2)位小数！","不可小于最小变更数"]}},{columnIndex:"newProductPrice",width:"130",componentName:"input",_cellConfig:{rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]{1,4})?$"}],message:["此项不能为空！","请输入大于零的整数或(1,4)位小数！"]}},{columnIndex:"productSum",width:"120",componentName:"dynaContent",_cellConfig:{compute:"self@newOrderCount(*)self@newProductPrice",hideTitle:!0}},{columnIndex:"newDeliverDate",width:"180",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",rules:[{required:!0}],message:["此项不能为空！"]}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{}}},beforeCreate:function(){},created:function(){this.temp=this.initData.temp,this.temp.orderId=this.initData.temp.id,this.temp.receiptTypeBefore=this.initData.temp.receiptType,this.apiObj.params.parentId=this.initData.temp.id},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.orderDtlList=[],Array.isArray(e)&&(this.orderDtlList=e)},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.orderDtlList=[],e.$refs.orderEditDialog.getData(),null!=e.orderDtlList&&e.orderDtlList.length>0&&e.saveSaleOrder(e.orderDtlList))})},saveSaleOrder:function(e){var t=this;this.temp.receiptTypeAfter=this.temp.receiptType;for(var i=[],o=0;o<e.length;o++){var a=e[o],n={orderDtlId:a.id,orderCountBefore:a.orderCount,orderCountAfter:a.newOrderCount,productPriceBefore:a.productPrice,productPriceAfter:a.newProductPrice,deliverDateBefore:a.deliverDate,deliverDateAfter:a.newDeliverDate,deliverCount:a.deliverCount,retreatCount:a.retreatMoneyCount};i.push(n)}this.temp.dtlJsonStr="",null!=i&&i.length>0&&(this.temp.dtlJsonStr=JSON.stringify(i)),Object(r.checkSaleOrderChange)(this.temp).then(function(e){"true"==e.isChange?t.$confirm("保存后将该订单提交变更审核, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.addSaleOrderChange)(t.temp).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}).catch(function(){t.$message({type:"info",message:"已取消操作"})}):t.$message({type:"warning",duration:5e3,showClose:!0,message:"(发票类型,订购数量,单价,约定交期)与原数据相同，无需提交变更！"})})},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName},size:function(){return this.$store.getters.size},formItemWidth:function(){var e={};switch(this.size){case"mini":e.width="180px";break;case"small":e.width="200px";break;default:e.width="220px"}return e}},watch:{}},n=i("KHd+"),l=Object(n.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px",size:e.size}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[i("el-input",{style:e.formItemWidth,attrs:{readonly:!0},model:{value:e.temp.customerName,callback:function(t){e.$set(e.temp,"customerName",t)},expression:"temp.customerName"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[i("el-date-picker",{style:e.formItemWidth,attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd",readonly:!0},model:{value:e.temp.orderDate,callback:function(t){e.$set(e.temp,"orderDate",t)},expression:"temp.orderDate"}})],1)],1),e._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[i("el-select",{style:e.formItemWidth,attrs:{placeholder:"发票类型"},model:{value:e.temp.receiptType,callback:function(t){e.$set(e.temp,"receiptType",t)},expression:"temp.receiptType"}},[i("el-option",{attrs:{label:"不开票",value:"1"}}),e._v(" "),i("el-option",{attrs:{label:"增值税普通发票",value:"2"}}),e._v(" "),i("el-option",{attrs:{label:"增值税专用发票",value:"3"}})],1)],1)],1)],1),e._v(" "),i("el-row",{staticStyle:{width:"96%","margin-left":"2%"}},[i("custom-base-table",{ref:"orderEditDialog",attrs:{"data-custom-table-id":"views_sale_order_dialogOrderChange0",isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"orderEditDialog",useDefaultBtn:!1,showAll:!1,keyMapping:e.keyMapping},on:{databridge:e.databridge}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogOrderChange.vue";t.default=l.exports}}]);