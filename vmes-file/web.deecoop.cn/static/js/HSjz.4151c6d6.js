(window.webpackJsonp=window.webpackJsonp||[]).push([["HSjz"],{HSjz:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("yt8O"),i("XfO3"),i("9AAn");var a=i("2+ib"),n=i("wMKg"),o={components:{multilevelTable:a.a},props:["initData","visible"],data:function(){return{signDtlId:"",qualityTypeSelect:{},rowData:{},qualityTypeNameMap:new Map([["全检","1"],["抽检","2"]]),tableData:[],tableConfigList:[{customColumn:[{columnIndex:"prodInfo",width:"200",_cellConfig:{hideTitle:!0}},{columnIndex:"qualityTypeName",width:"100",componentName:"select",_cellConfig:{outputData:!0,hideTitle:!0,options:[{id:"全检",label:"全检"},{id:"抽检",label:"抽检"}]}},{columnIndex:"qualityCount",width:"120",componentName:"input",_cellConfig:{disabledState:{key:"qualityTypeValue",value:"1"},rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]+){0,1}$"},{greaterThan:["0",!1]}],message:["不可为空！","请输入大于零的整数或小数","不可等于零！"]}},{columnIndex:"badCount",width:"120",componentName:"input",_cellConfig:{rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]+){0,1}$"}],message:["不可为空！","请输入大于零的整数或小数"]}},{columnIndex:"retreatCount",width:"120",componentName:"input",_cellConfig:{rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]+){0,1}$"}],message:["不可为空！","请输入大于零的整数或小数"]}},{columnIndex:"receiveCount",width:"120",componentName:"input",_cellConfig:{rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]+){0,1}$"}],message:["不可为空！","请输入大于零的整数或小数"]}}],apiObj:{apiName:"listPagePurchaseSignDetailByQualityExecute",params:{fieldCode:"prodInfo,orderUnitName,qualityTypeName,arriveCount,qualityCount,badCount,retreatCount,receiveCount,",prodColumnKey:"productCode,productName,productSpec,productProperty",signDtlId:""}},tempData:{},showHeader:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"all",rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"badCount",componentName:"input",_cellConfig:{rules:[{required:!0},{regexp:"^[0-9]+([.]{1}[0-9]+){0,1}$"}],message:["不可为空！","请输入大于零的整数或小数"]}}],apiObj:{apiName:"findQualityByPurchaseSignDtl",params:{fieldCode:"qualityName,qualityCriterion,badCount",business:"purchase",isNeedPage:"false",orderStr:"cdate asc"}},dynamicValue:{productId:"self@productId"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable",leftFixed:1,rightFixed:1}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!1,isVisible:!1,inDialog:!0}},beforeCreate:function(){},created:function(){this.signDtlId=this.initData.rowData.id,this.tableConfigList[0].apiObj.params.signDtlId=this.initData.rowData.id},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},getData:function(){this.$refs.customBaseTable.getData()},databridge:function(e){Array.isArray(e)?(this.tableData=[],this.tableData=e):(null!=e.item&&(this.qualityTypeSelect=e.item),null!=e.item&&null!=e.row&&(this.rowData=e.row),this.setQualityTypeValue(this.qualityTypeSelect,this.rowData),this.setQualityCountDefault(this.qualityTypeSelect,this.rowData))},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},closeDialog:function(){},deleteRow:function(e){this.deleteData(e)},setQualityTypeValue:function(e,t){var i=e.id,a=this.qualityTypeNameMap.get(i);t.qualityTypeValue=a},setQualityCountDefault:function(e,t){var i=e.id,a=this.qualityTypeNameMap.get(i);"1"==a?t.qualityCount=t.arriveCount:"2"==a&&(t.qualityCount="0.00")},findSumBadCount:function(e){var t=0;if(null!=e&&e.length>0)for(var i=0;i<e.length;i++){t+=e[i].badCount/1}return t},findMinimumBadCount:function(e){var t=0;if(null!=e&&e.length>0)for(var i=0;i<e.length;i++){var a=e[i].badCount/1;a>0&&0==t?t=a:a>0&&a<t&&(t=a)}return t},checkColumnByFirst:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n=a.qualityTypeValue,o=a.arriveCount,l=a.qualityCount;"1"==n&&l/1-o/1!=0?t+="检验方式(全检) 实检数必须与签收数相等！":"2"==n&&l/1-o/1>0&&(t+="检验方式(抽检) 实检数不可大于签收数！");var u=a.badCount/1;a.retreatCount/1+a.receiveCount/1-u!=0&&(t+="不合格数必须等于(退货数+让步接收)！")}return t},checkColumnBySecond_1:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n=a.qualityCount,o=a.children;if(null!=o&&o.length>0)for(var l=0;l<o.length;l++){o[l].badCount/1>n&&(t+="检验不合格不可大于实检数！")}}return t},checkColumnBySecond_2:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n=a.badCount/1,o=a.children;if(null!=o&&o.length>0)for(var l=0;l<o.length;l++){o[l].badCount/1>n&&(t+="检验不合格不可大于不合格数！")}var u=this.findSumBadCount(o);if(u>0){var r=this.findMinimumBadCount(o);n<r&&(t=t+"不合格数不可小于"+r+"！")}n>u&&(t+="不合格数不可大于检验不合格总和！")}return t},findJsonStringByTable:function(e){for(var t=[],i=0;i<e.length;i++){var a=e[i],n="全检";null!=a.qualityTypeName&&null!=a.qualityTypeName.item&&null!=a.qualityTypeName.item.id?n=a.qualityTypeName.item.id:null!=a.qualityTypeName&&a.qualityTypeName.trim().length>0&&(n=a.qualityTypeName.trim());for(var o=this.qualityTypeNameMap.get(n),l={id:a.id,qualityType:o,arriveCount:a.arriveCount,qualityCount:a.qualityCount,badCount:a.badCount,retreatCount:a.retreatCount,receiveCount:a.receiveCount,parentId:a.parentId,productId:a.productId,p2nFormula:a.p2nFormula,p2nIsScale:a.p2nIsScale,p2nDecimalCount:a.p2nDecimalCount,signCode:a.signCode,orderId:a.orderId,orderDtlId:a.orderDetailId,price:a.price,orderUnit:a.orderUnit,supplierId:a.supplierId,supplierName:a.supplierName,children:""},u=[],r=a.children,s=0;s<r.length;s++){var d=r[s],c={signDetailId:a.id,productId:a.productId,orderUnit:a.orderUnit,qualityId:d.id,badCount:d.badCount};u.push(c)}l.children=u,t.push(l)}return JSON.stringify(t)},save:function(){this.getData(),null!=this.tableData&&this.tableData.length>0&&this.addWarehouseInExecute(this.tableData)},addWarehouseInExecute:function(e){var t=this,i=this.checkColumnByFirst(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else if(null!=(i=this.checkColumnBySecond_1(e))&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else if(null!=(i=this.checkColumnBySecond_2(e))&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var a=this.findJsonStringByTable(e);this.dialogLoading=!0,Object(n.purchaseSignDetailByQualityExecute)({roleId:this.$storage.get("userInfo").roleIds,jsonStr:a}).then(function(e){0===e.code&&(t.dialogLoading=!1,t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}}},watch:{}},l=i("KHd+"),u=Object(l.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-row",{staticStyle:{width:"96%","margin-left":"2%","margin-bottom":"5px",border:"1px solid #E4E4E4","border-bottom":"none"}},[i("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_quality_purchaseSignByQuality_dialogExecute0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogExecute.vue";t.default=u.exports}}]);