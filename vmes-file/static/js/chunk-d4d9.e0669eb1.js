(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-d4d9","chunk-c4b4","chunk-3afb","chunk-3af6","a0Xs"],{"/RvK":function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var a=i("ddId"),n=i("rwyD"),o=(i("a0Xs"),i("z0WU")),s=i("mSNy");function r(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function l(t){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.productPrice" @change="colConfig.productPriceChange(scope.row,scope.$index)" />\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={components:{},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{fieldCode:"productCode,productName,productSpec,productGenreName,priceUnitName,count,productPrice,productSum,deliverDate,remark",rules:{customerName:[{required:!0,message:"请选择客户名称",trigger:"change"}],receiptTypeName:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.receiptType.length<=0?a(new Error("请选择发票类型")):a()}}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}],orderDate:[{required:!0,message:"请填写下单日期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{id:"",discountSum:"",advanceSum:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.temp=this.initData.temp,this.initTable(null,this.initData.temp.id)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=l(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==s.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==s.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==s.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==s.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"productPrice"===t.prop&&(t.component=c,t.productPriceChange=e.productPriceChange)}),this.internationalConfig(),t},internationalConfig:function(){"en"==s.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==s.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(t,e){var i=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(n.listPageSaleOrderDetail)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){r(t,e,i[e])})}return t}({},this.tempQuery,{fieldCode:this.fieldCode,parentId:e,pageNo:this.pageNo})).then(function(t){i.getListPage(t),i.$loading().close()}).catch(function(t){i.$loading().close()})},dataBridge:function(t){},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},checkNumber:function(t,e){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.$message({type:"warning",duration:5e3,showClose:!0,message:e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"})},checkDiscountSum:function(t){this.checkNumber(t,"折扣金额")},checkAdvanceSum:function(t){null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&this.checkNumber(t,"预付款")},checkColumn:function(t){for(var e="",i=0;i<t.length;i++){var a=t[i].productPrice;null!=a&&0!=a.trim().length||(e=e+"第 "+(i+1)+" 行: 单价为空或空字符串！"),null!=a&&a.trim().length>0&&!this.isNumberByValue(a.trim())&&(e=e+"第 "+(index+1)+" 行: 单价("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！")}return e},saveSaleOrder:function(){var t,e=this,i=this.temp.discountSum;null!=i&&i.trim().length>0&&this.checkNumber(i,"折扣金额");var n=this.temp.advanceSum;null!=n&&n.trim().length>0&&this.checkNumber(n,"预付款");var o=this.checkColumn(this.tableData);if(null!=o&&o.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:o});else{for(var s=[],r=0;r<this.tableData.length;r++){var l=this.tableData[r],c={id:"",productPrice:"",productSum:""};c.id=l.id,c.productPrice=l.productPrice,c.productSum=l.productSum,s.push(c)}t=JSON.stringify(s),this.temp.dtlJsonStr=t,this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(a.e)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){}))})}},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},productPriceChange:function(t,e){var i=t.productPrice;if(null!=i&&i.trim().length>0&&!this.isNumberByValue(i))this.$message({showClose:!0,message:"第 "+(e+1)+" 行: 单价("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});else{var a=t.count;if(null!=a&&a.trim().length>0){if(!this.isNumberByValue(a))return void this.$message({showClose:!0,message:"第 "+(e+1)+" 行: 订购数量("+a+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3});t.productSum=(a.trim()*i.trim()).toFixed(2)}}},closeDialog:function(t){}},watch:{pageNo:function(){this.initTable("add","")}}},d=i("KHd+"),p=Object(d.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.customerName,callback:function(e){t.$set(t.temp,"customerName",e)},expression:"temp.customerName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发票类型:",prop:"receiptTypeName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.receiptTypeName,callback:function(e){t.$set(t.temp,"receiptTypeName",e)},expression:"temp.receiptTypeName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"下单日期:",prop:"orderDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"下单日期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:t.temp.orderDate,callback:function(e){t.$set(t.temp,"orderDate",e)},expression:"temp.orderDate"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"交付日期:",prop:"deliverDate"}},[i("el-date-picker",{staticStyle:{width:"230px"},attrs:{type:"date",placeholder:"交付日期","value-format":"yyyy-MM-dd",disabled:!0},model:{value:t.temp.deliverDate,callback:function(e){t.$set(t.temp,"deliverDate",e)},expression:"temp.deliverDate"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"230px"},attrs:{disabled:!0},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"折扣金额:",prop:"discountSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:t.checkDiscountSum},model:{value:t.temp.discountSum,callback:function(e){t.$set(t.temp,"discountSum",e)},expression:"temp.discountSum"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"预付款:",prop:"advanceSum"}},[i("el-input",{staticStyle:{width:"230px"},on:{change:t.checkAdvanceSum},model:{value:t.temp.advanceSum,callback:function(e){t.$set(t.temp,"advanceSum",e)},expression:"temp.advanceSum"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}})],1),t._v(" "),i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveSaleOrder}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogEdit.vue";e.default=p.exports},"78mO":function(t,e,i){},"9WTv":function(t,e,i){"use strict";i.d(e,"d",function(){return n}),i.d(e,"a",function(){return o}),i.d(e,"f",function(){return s}),i.d(e,"e",function(){return r}),i.d(e,"b",function(){return l}),i.d(e,"c",function(){return c});var a=i("t3Un");function n(t){return Object(a.a)({url:"/equipment/listPageEquipments",method:"post",data:t})}function o(t){return Object(a.a)({url:"/equipment/addEquipment",method:"post",data:t})}function s(t){return Object(a.a)({url:"/equipment/updateEquipment",method:"post",data:t})}function r(t,e){return Object(a.a)({url:"/equipment/update",method:"post",data:{id:t,isdisable:e}})}function l(t){return Object(a.a)({url:"/equipment/deleteByIds",method:"post",data:{ids:t}})}function c(t){return Object(a.a)({url:"/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:t}})}},"9m9g":function(t,e,i){"use strict";i.r(e);i("91GP"),i("rGqo");var a=i("zDZ1"),n=i("lX1r"),o=i("uTIz"),s=i("/RvK"),r=i("rIO6"),l=i("kyJt"),c=i("ddId"),u=i("Vobf");i("z0WU");function d(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t    <el-button v-show="colConfig.editByParent_isShow && scope.row.state == \'1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.editByParent(scope.row,scope.$index)">编辑</el-button>\n    \t\t\t\t\t    <el-button v-show="colConfig.auditPassByParent_isShow && scope.row.state == \'1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.auditPassByParent(scope.row,scope.$index)">通过</el-button>\n    \t\t\t\t\t\t\t<el-button v-show="colConfig.auditDisagreeByParent_isShow && scope.row.state == \'1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.auditDisagreeByParent(scope.row,scope.$index,scope)">退回</el-button>\n    \t\t\t\t\t    <el-button v-show="colConfig.infoByParent_isShow" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.infoByParent(scope.row,scope.$index)">详情</el-button>\n    \t\t\t\t\t\t\t\x3c!--<el-button v-show="colConfig.recoveryByParent_isShow && scope.row.state == \'-1\'" type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.recoveryByParent(scope.row,scope.$index,scope)">恢复</el-button>--\x3e\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},m={components:{dialogQrcode:a.a,expandTable:n.a,searchBar:o.a,dialogEdit:s.default,dialogLockStock:l.default,dialogRebackBill:r.default},data:function(){var t;return d(t={isLockStock:"",colConfigs:[],initData:{},childrenDialogTitleList:[],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"}],guid:"",currentpage:1,maxLayer:2,expandTableApiList:["listPageSaleOrder","listPageSaleOrderDetail"],expandTableApiParams:[{state:"1"},{parentId:""}],initParams:{},updateViewData:{},searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{1:[{columnIndex:"last",prop:"operate",label:"操作",component:p,infoByParent:this.infoByParent,infoByParent_isShow:!0,editByParent:this.editByParent,editByParent_isShow:!0,auditPassByParent:this.auditPassByParent,auditPassByParent_isShow:!0,auditDisagreeByParent:this.auditDisagreeByParent,auditDisagreeByParent_isShow:!0}],2:[{}]},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},configs:{topBarBtnList:[],tableConfigs:[]},temp:{},openDialogName:""},"showDialog",!1),d(t,"visible",!1),d(t,"dialogData",{title:"",temp:null,tempLable:null,detailIds:""}),t},beforeCreate:function(){},created:function(){this.initButtons(),this.initExpandTable()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(u.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var a in t.customColumn)if(a){var n=t.customColumn[a];n.length>0&&n.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},initExpandTable:function(){var t=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.expandTableApiParams[0],this.currentpage)).then(function(e){t.initData={row:null,layer:1,res:e,customColumn:t.customColumn},t.$loading().close()}).catch(function(e){t.$loading().close()})},databridge:function(t){this.temp.dataList=t},findChildByRow:function(t,e,i,a,n){var o=this;this.$api[this.expandTableApiList[e-1]](this.setParams(e,t,n)).then(function(i){o.childrenData={row:t,layer:e,res:i,customColumn:o.customColumn}}).catch(function(t){})},setParams:function(t,e,i){var a=Object.assign({},this.expandTableApiParams[t-1]);for(var n in a)a.hasOwnProperty(n)&&!a[n]&&(a[n]=e[n]||"");return Object.assign({},a,this.searchObj,{pageNo:i})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.initExpandTable()},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1;var e=t.pageName;this.isLockStock="","dialogLockStock"==e&&"ok"===t.resState&&(this.isLockStock="Y"),"dialogLockStock"!=e&&"ok"===t.resState&&this.initExpandTable()},orderSubmit:function(){var t=this,e=[],i=this.temp.dataList;null!=i&&i.length>0&&i.forEach(function(t){null!=t.id&&t.id.trim().length>0&&e.push({id:t.id.trim()})}),0!=e.length?this.$confirm("此操作将订单提交, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var i=JSON.stringify(e);submitSaleOrder({orderJsonStr:i}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"提交成功",type:"success",duration:2e3}),t.initExpandTable())}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消订单提交"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少勾选一条订单！"})},editByParent:function(t,e){this.resetTemp(),this.dialogData.temp=t,this.dialogData.title="编辑订单",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},auditDisagreeByParent:function(t,e){this.dialogData.temp=t,this.dialogData.title="审核退回",this.openDialogName="dialogRebackBill",this.showDialog=!0,this.visible=!0},auditPassByParent:function(t,e){var i=this;Object(c.c)({orderId:t.id,customerId:t.customerId}).then(function(e){var a={orderId:t.id,isCustomerPrice:"N"};if(0===e.code){var n=e.isShowProductPrice;null!=n&&"Y"==n&&i.$confirm("该订单明细中货品单价与该订单客户在系统中历史最新货品单价不一致, 是否将该订单货品单价更新到系统中?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.isCustomerPrice="Y"}).catch(function(){i.$message({type:"info",message:"已取消货品单价更新"})});var o=e.isNeedLockStock;null!=o&&"Y"==o?i.$confirm("该订单明细货品存在与系统库存中,该订单可以出库操作， 是否进行锁定库存?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){null!=e.needLockStockOrderDtlIds&&e.needLockStockOrderDtlIds.trim().length>0&&(t.needLockStockOrderDtlIds=e.needLockStockOrderDtlIds.trim(),i.dialogData.detailIds=e.needLockStockOrderDtlIds.trim()),i.dialogData.title="锁定库存",i.openDialogName="dialogLockStock",i.showDialog=!0,i.visible=!0}).catch(function(){i.isLockStock="Y",i.$message({type:"info",message:"已取消锁定库存"})}):i.isLockStock="Y","Y"===i.isLockStock&&Object(c.b)(a).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),i.initExpandTable())}).catch(function(t){})}}).catch(function(t){})},executorByDetail:function(t,e){this.resetTemp(),this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="查看执行人",this.openDialogName="dialogViewExecutor",this.showDialog=!0,this.visible=!0},exportExcel:function(){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{currentpage:function(){this.initExpandTable()}}},f=(i("PRRt"),i("KHd+")),g=Object(f.a)(m,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"orderAudit"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("expand-table",{attrs:{initData:t.initData,childrenData:t.childrenData,configs:t.tableSets,currentpage:t.currentpage,maxLayer:t.maxLayer,apiObj:{apiName:t.expandTableApiList,apiParams:t.expandTableApiParams},updateViewData:t.updateViewData},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.databridge,"send-children-row":t.findChildByRow}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);g.options.__file="index.vue";e.default=g.exports},Nm4q:function(t,e,i){"use strict";var a=i("78mO");i.n(a).a},PRRt:function(t,e,i){"use strict";var a=i("tSA/");i.n(a).a},a0Xs:function(t,e,i){"use strict";i.d(e,"e",function(){return n}),i.d(e,"d",function(){return o}),i.d(e,"f",function(){return s}),i.d(e,"g",function(){return r}),i.d(e,"h",function(){return l}),i.d(e,"a",function(){return c}),i.d(e,"i",function(){return u}),i.d(e,"j",function(){return d}),i.d(e,"b",function(){return p}),i.d(e,"c",function(){return m});var a=i("t3Un");function n(t){return Object(a.a)({url:"/productUnit/listPageProductUnits",method:"post",data:t})}function o(t){return Object(a.a)({url:"/productUnitPrice/listPageProductUnitPrices",method:"post",data:t})}function s(t){return Object(a.a)({url:"/productUnit/save",method:"post",data:t})}function r(t,e){return Object(a.a)({url:"/productUnit/update",method:"post",data:{id:t,isdisable:e}})}function l(t,e,i){return Object(a.a)({url:"/productUnit/updateIsDefaultProductUnit",method:"post",data:{id:t,isdefault:e,productId:i}})}function c(t){return Object(a.a)({url:"/productUnit/deleteByIds",method:"post",data:{ids:t}})}function u(t){return Object(a.a)({url:"/productUnit/update",method:"post",data:t})}function d(t){return Object(a.a)({url:"/productUnit/updateProductUnitPrice",method:"post",data:t})}function p(t){return Object(a.a)({url:"/productUnit/findListProductUnit",method:"post",data:{productId:t}})}function m(t){return Object(a.a)({url:"/productUnit/formulaReckonByProductCount",method:"post",data:t})}},ddId:function(t,e,i){"use strict";i.d(e,"d",function(){return n}),i.d(e,"c",function(){return o}),i.d(e,"f",function(){return s}),i.d(e,"e",function(){return r}),i.d(e,"b",function(){return l}),i.d(e,"a",function(){return c});var a=i("t3Un");function n(t){return Object(a.a)({url:"/saleOrderAudit/listPageSaleOrderDetailByLockStock",method:"post",data:t})}function o(t){return Object(a.a)({url:"/saleOrderAudit/checkSaleOrderByAudit",method:"post",data:t})}function s(t){return Object(a.a)({url:"/saleOrderAudit/updateSaleOrderDetailByLockStock",method:"post",data:t})}function r(t){return Object(a.a)({url:"/saleOrderAudit/updateSaleOrderByAudit",method:"post",data:t})}function l(t){return Object(a.a)({url:"/saleOrderAudit/auditPassSaleOrder",method:"post",data:t})}function c(t){return Object(a.a)({url:"/saleOrderAudit/auditDisagreeSaleOrder",method:"post",data:t})}},kyJt:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("Oyvg"),i("rGqo");var a=i("ddId"),n=i("z0WU"),o=i("mSNy");function s(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.lockCount" @change="colConfig.lockCountChange(scope.row,scope.$index)"/>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{orderId:"",needLockStockOrderDtlIds:"",rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{}},configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){var t="";null!=this.initData.detailIds&&this.initData.detailIds.trim().length>0&&(t=this.initData.detailIds.trim()),this.initTable(t)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(n.j)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==o.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==o.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==o.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"lockCount"===t.prop&&(t.component=l,t.lockCountChange=e.lockCountChange)}),this.internationalConfig(),t},internationalConfig:function(){"en"==o.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==o.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(t){var e=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(a.d)(function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){s(t,e,i[e])})}return t}({},this.tempQuery,{detailIds:t,pageNo:this.pageNo})).then(function(t){e.getListPage(t),e.$loading().close()}).catch(function(t){e.$loading().close()})},dataBridge:function(t){},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkColumn:function(t){for(var e="",i=0;i<t.length;i++){var a=t[i],n=a.allowStockCount,o=a.lockCount;null!=o&&o.trim().length>0&&!this.isNumberByValue(o.trim())?e=e+"第 "+(index+1)+" 行: 锁定货品数量("+o+") 输入错误，请输入大于零的正整数或(1,2)位小数！":null!=o&&o.trim().length>0&&null!=n&&n.trim().length>0&&o-n>0&&(e=e+"第 "+(index+1)+" 行: 锁定货品数量("+o+") 输入错误，必须输入小于或等于库存可用数量！")}return e},saveSaleOrder:function(){var t=this;if(null!=this.tableData&&0!=this.tableData.length){var e=this.checkColumn(this.tableData);if(null!=e&&e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var i="",n=[];this.tableData.forEach(function(t){var e=t.productId;null!=e&&e.trim().length>0&&(i=i+e.trim()+","),n.push({id:t.id,productId:t.productId,lockCount:t.lockCount})});var o=JSON.stringify(n);Object(a.f)({productIds:i,dtlJsonStr:o}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"订单锁定库存成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok",pageName:"dialogLockStock"}))}).catch(function(t){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前订单明细中的货品在系统中无可用库存，无需锁定库存！"})},lockCountChange:function(t,e){var i=t.lockCount;null!=i&&i.trim().length>0&&!this.isNumberByValue(i)&&this.$message({showClose:!0,message:"第 "+(e+1)+" 行: 锁定货品数量("+i+") 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3})},closeDialog:function(t){}}},u=i("KHd+"),d=Object(u.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),i("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveSaleOrder}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogLockStock.vue";e.default=d.exports},lZYi:function(t,e,i){"use strict";var a=i("wnxv");i.n(a).a},rIO6:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("ddId");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){this.orderId=this.initData.temp.id},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){if(e){t.dialogLoading=!0;var i=t.$storage.get("userInfo").userName;Object(a.a)({orderId:t.orderId,remark:t.temp.remark,userName:i}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}})}}},s=i("KHd+"),r=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"退回原因:",prop:"remark"}},[i("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);r.options.__file="dialogRebackBill.vue";e.default=r.exports},"tSA/":function(t,e,i){},wnxv:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://116.196.105.79:8080/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t=document.getElementById("printContent").innerHTML,e=document.body.innerHTML;return document.body.innerHTML=t,window.print(),window.location.reload(),document.body.innerHTML=e,!1}}},o=(i("lZYi"),i("Nm4q"),i("KHd+")),s=Object(o.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"c9e885e4",null);s.options.__file="dialogQrcode.vue";e.a=s.exports}}]);