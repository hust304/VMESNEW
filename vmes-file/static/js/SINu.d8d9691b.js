(window.webpackJsonp=window.webpackJsonp||[]).push([["SINu"],{SINu:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("Oyvg");var o=i("WIyV"),a=i("AUoE"),n=(i("a0Xs"),{components:{customBaseTable:o.a},props:["initData","visible"],data:function(){return{priceType:"2",productUnit:{},rowData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},isVisible:!1,inDialog:!0,tableData:[],orderDtlList:[],apiObj:{apiName:"listPageOrderDetailQueryByDeliver",params:{pageNo:1,ids:"",fieldCode:"productCode,productName,productSpec,productGenreName,orderUnitName,orderCount,productStockCount,notDeliverCount,orderDtlDeliverCount,deliverDtlRemark"}},customColumn:[{columnIndex:"orderDtlDeliverCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"},{greaterThan:["0",!1]}],message:["请输入数字！","必须大于零！"]}},{columnIndex:"deliverDtlRemark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""}}},beforeCreate:function(){},created:function(){var e=this.initData.orderDtlIds;this.apiObj.params.ids=e},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)?(this.orderDtlList=[],this.orderDtlList=e):(this.productUnit=null,null!=e.item&&(this.productUnit=e.item),this.rowData=null,null!=e.item&&(this.rowData=e.row))},save:function(){this.$refs.addDeliverByPriceDialog.getData(),this.saveSaleDeliver(this.orderDtlList)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(e.trim())},checkNumber:function(e,t){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t+"("+e+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var o=e[i],a=o.notDeliverCount,n=o.orderDtlDeliverCount;null==n||0==(n+"").trim().length?t=t+"第 "+(i+1)+" 行: 本次发货数量为空或空字符串！":(n+="",this.isNumberByValue(n.trim())?(n=(n+"").trim())-a>0&&(t=t+"第 "+(i+1)+" 行: 本次发货数量不可大于未发货数量！"):t=t+"第 "+(i+1)+" 行: 本次发货数量("+n.trim()+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleDeliver:function(e){var t=this;if(null!=e&&0!=e.length){var i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var o=[];e.forEach(function(e){o.push(e)});var n=JSON.stringify(o);Object(a.addSaleDeliver)({roleId:this.$storage.get("userInfo").roleIds,priceType:this.priceType,dtlJsonStr:n}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条订单明细！"})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}}),l=i("KHd+"),r=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",[i("el-row",{staticStyle:{padding:"10px"}},[i("custom-base-table",{ref:"addDeliverByPriceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,tempData:e.tempData,componentId:"addDeliverByPriceDialog",useDefaultBtn:!0,showAll:!1,keyMapping:e.keyMapping},on:{databridge:e.databridge}})],1),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogAddDeliverDetailByPrice.vue";t.default=r.exports}}]);