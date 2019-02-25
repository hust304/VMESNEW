(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-776d"],{hmHw:function(e,t,i){"use strict";i.r(t);i("rGqo"),i("Oyvg");var l=i("WIyV"),n=i("OsNz"),a={components:{customBaseTable:l.a},props:["initData","visible"],data:function(){return{deliverId:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},isVisible:!1,inDialog:!0,tableData:[],orderDtlList:[],productUnit:{},rowData:{},apiObj:{apiName:"listPageSaleDeliverDetailByPrice",params:{pageNo:1,parentId:""}},customColumn:[{columnIndex:"priceUnitName",componentName:"select",_cellConfig:{asyn:{apiName:"findListProductUnitByProduct",params:{productId:""}},rules:[{required:!0}],outputData:!0}},{columnIndex:"priceCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"productPrice",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"sum",_cellConfig:{hideTitle:!0,compute:"self@priceCount(*)self@productPrice"}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{maxExpectDate:""}}},beforeCreate:function(){},created:function(){this.deliverId=this.initData.deliverId,this.apiObj.params.parentId=this.deliverId},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){Array.isArray(e)?(this.orderDtlList=[],this.orderDtlList=e):(this.productUnit=null,null!=e.item&&(this.productUnit=e.item),this.rowData=null,null!=e.item&&(this.rowData=e.row),this.setProductPrice(this.productUnit,this.rowData),this.setProductSum(this.rowData))},save:function(){this.$refs.editDeliverDtlByPriceDialog.getData(),this.saveSaleDeliver(this.orderDtlList)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkNumber:function(e,t){null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:t+"("+e+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var l=e[i],n=l.priceCount;null!=n&&0!=n.trim().length||(t=t+"第 "+(i+1)+" 行: 结算数量为空或空字符串！");var a=l.productPrice;null!=a&&0!=a.trim().length||(t=t+"第 "+(i+1)+" 行: 结算单价为空或空字符串！"),null!=n&&n.trim().length>0&&!this.isNumberByValue(n.trim())&&(t=t+"第 "+(i+1)+" 行: 结算数量("+n+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(t=t+"第 "+(i+1)+" 行: 结算单价("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return t},saveSaleDeliver:function(e){var t=this;if(null!=e&&0!=e.length){var i=this.checkColumn(e);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var l=[];e.forEach(function(e){var t={id:"",priceUnit:"",priceCount:"",productPrice:"",orderId:"",orderDetaiId:""};t.id=e.id,t.priceUnit=e.priceUnit,t.priceCount=e.priceCount,t.productPrice=e.productPrice,t.orderId=e.orderId,t.orderDetaiId=e.orderDetaiId,l.push(t)});var a=JSON.stringify(l);Object(n.updateSaleDeliverDetailByPrice)({deliverId:this.deliverId,dtlJsonStr:a}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},setProductPrice:function(e,t){null!=e&&null!=t&&(null!=e.id&&(t.priceUnit=e.id),null!=e.productPrice&&(t.productPrice=e.productPrice))},setProductSum:function(e){if(null!=e){e.sum="";var t=e.priceCount,i=e.productPrice;null!=t&&t.trim().length>0&&null!=i&&i.trim().length>0&&(e.sum=(t.trim()*i.trim()).toFixed(2))}},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},o=i("KHd+"),r=Object(o.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{staticStyle:{height:"500px"}},[i("el-row",{staticStyle:{"margin-left":"10px"}},[i("div",{staticStyle:{height:"400px"}},[i("custom-base-table",{ref:"editDeliverDtlByPriceDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,tempData:e.tempData,componentId:"editDeliverDtlByPriceDialog",useDefaultBtn:!0,showAll:!1,keyMapping:e.keyMapping},on:{databridge:e.databridge}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogDetailEditByPrice.vue";t.default=r.exports},yO6P:function(e,t,i){"use strict";var l=i("YP4+"),n={};n[l.a.code]="^[A-Za-z0-9]{placeholder}$",n[l.a.number]="\\d{placeholder}$",n[l.a.date]="^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$",n[l.a.time]="^([0-2][0-9]\\:[0-5][0-9]\\:[0-5][0-9])|([0-2][0-9]\\:[0-5][0-9])$",n[l.a.mobile]="^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",n[l.a.email]="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",n[l.a.url]="[a-zA-z]+:\\/\\/[^\\s]*",n[l.a.zh]="^[一-龥]{placeholder}$",n[l.a.en]="^[A-Za-z]{placeholder}$",n[l.a.identity]="^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X|x)$",n[l.a.float]="^(-?\\d+\\.\\d+)?$",n[l.a.int]="^-?\\d+$",t.a=n}}]);