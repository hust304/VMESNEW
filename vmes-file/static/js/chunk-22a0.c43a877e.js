(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-22a0","chunk-6812"],{"9rC1":function(t,e,a){"use strict";a.d(e,"g",function(){return n}),a.d(e,"h",function(){return o}),a.d(e,"e",function(){return s}),a.d(e,"a",function(){return l}),a.d(e,"i",function(){return r}),a.d(e,"k",function(){return u}),a.d(e,"c",function(){return c}),a.d(e,"d",function(){return d}),a.d(e,"f",function(){return m}),a.d(e,"j",function(){return p}),a.d(e,"b",function(){return h});var i=a("t3Un");function n(t){return Object(i.a)({url:"/base/customer/listPageCustomers",method:"post",data:t})}function o(t){return Object(i.a)({url:"/base/customer/listTreeCustomer",method:"post",data:t})}function s(t){return Object(i.a)({url:"/base/customer/listPageCustomerAccountDays",method:"post",data:t})}function l(t){return Object(i.a)({url:"/base/customer/addCustomer",method:"post",data:t})}function r(t){return Object(i.a)({url:"/base/customer/updateCustomer",method:"post",data:t})}function u(t,e){return Object(i.a)({url:"/base/customer/updateDisableCustomer",method:"post",data:{id:t,isdisable:e}})}function c(t){return Object(i.a)({url:"/base/customer/deleteCustomers",method:"post",data:{ids:t}})}function d(t){return Object(i.a)({url:"/base/customer/exportExcelCustomers",method:"post",responseType:"blob",data:{ids:t}})}function m(t){return Object(i.a)({url:"/base/customer/listPageCustomerReceive",method:"post",data:t})}function p(t){return Object(i.a)({url:"/base/customer/updateCustomerBalance",method:"post",data:t})}function h(t){return Object(i.a)({url:"/base/customer/addCustomerBalance",method:"post",data:t})}},G9cW:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("xfY5"),a("9rC1");function i(t){return(i="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.totalBalance=Number(this.temp.addBalance)+Number(this.temp.balance)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=i(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this,e=this;this.temp.currentBalance>this.temp.totalBalance?this.$message({showClose:!0,message:"当前分摊金额不能大于预收款！",duration:5e3}):e.$refs.submitForm.validate(function(a){a&&(e.isVisible=!1,e.dialogClose({resState:"ok",currentBalance:t.temp.currentBalance}))})}}},o=(a("LspI"),a("KHd+")),s=Object(o.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.dialogWidth},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-form-item",{attrs:{label:"预收款:",prop:"totalBalance"}},[a("el-input",{staticStyle:{width:"140px"},attrs:{disabled:!0},model:{value:t.temp.totalBalance,callback:function(e){t.$set(t.temp,"totalBalance",e)},expression:"temp.totalBalance"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"本次分摊金额:",prop:"currentBalance"}},[a("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.currentBalance,callback:function(e){t.$set(t.temp,"currentBalance",t._n(e))},expression:"temp.currentBalance"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"541ad4ce",null);s.options.__file="dialogReceiptBalanceEdit.vue";e.default=s.exports},LCER:function(t,e,a){"use strict";a.r(e);a("91GP");var i=a("uTIz"),n=a("G9cW"),o=a("kAts"),s=a("WIyV"),l=(a("z0WU"),{name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",selectList:[],temp:{},tempLable:{},pageData:null,pageNo:1,unapportionedValue:0,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null},customColumn:[{columnIndex:"receiveAmount",componentName:"input",_cellConfig:{rules:[{type:"number"},{required:!0},{lessThan:["tempData@currentBalance",!0]},{lessThan:["self@noReceiveAmount(-)self@discountAmount",!0]}],message:["输入类型必须是数字！","该单元格是必填项","必须小于等于本次分摊总额","本次收款金额与折扣金额之和必须小于等于应收金额！"]}},{columnIndex:"discountAmount",componentName:"input",_cellConfig:{rules:[{type:"number"},{lessThan:["self@noReceiveAmount(-)self@receiveAmount",!0]}],message:["输入类型必须是数字！","本次收款金额与折扣金额之和必须小于等于应收金额！"]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow}]}],apiObj:{apiName:"listPageOrderReceiveDetail",params:{pageNo:this.pageNo,queryStr:" saleOrder.id in ("+this.initData.ids+") ",fieldCode:"sysCode,orderSum,noReceiveAmount,discountAmount,receiveAmount "}},customSummary:{component:{props:["data","setStyle","tempData"],computed:{unapportionedValue:function(){var t=(this.tempData.currentBalance-this.data.orderAmount).toFixed(2);return/\d/.test(t)?(this.$emit("custom-summary-value",t),t):(this.$emit("custom-summary-value",""),"输入错误")}},template:'<ul class="clearfix" :style="setStyle">\n                        <li style="float: left;width: 100%"><span>剩余未分摊金额：</span><span>{{unapportionedValue}}元</span></li>\n                    </ul>'},data:{orderAmount:""},boxStyle:{width:"220px",float:"right",padding:"10px"},computes:{orderAmount:"table@receiveAmount"}}}},components:{searchBar:i.a,dialogReceiptBalanceEdit:n.default,customBaseTable:s.a},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.temp=this.initData.temp,this.temp.addBalance?this.temp.currentBalance=this.temp.addBalance:(this.temp.currentBalance=this.temp.balance,this.temp.addBalance=0),this.temp.lastBalance=0},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(t){this.$emit("close-dialog",t||{})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&(this.temp.currentBalance=t.currentBalance)},getData:function(){this.$refs.customBaseTable.getData()},dataBridge:function(t){var e=this;if(this.selectList=t,this.unapportionedValue>0||this.unapportionedValue<0)this.$message({type:"warning",duration:5e3,showClose:!0,message:"分摊明细总金额必须与本次分摊总额一致！"});else if(this.selectList.length>0){var a=JSON.stringify(this.selectList);this.temp.dtlJsonStr=a,this.dialogLoading=!0,Object(o.saveSaleReceiveAndDetail)(this.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"当前界面没有分摊明细，请重新选择分摊明细！"})},customSummaryValue:function(t){this.unapportionedValue=t},edit:function(){this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="本次分摊金额",this.openDialogName="dialogReceiptBalanceEdit",this.showDialog=!0,this.visibleState=!0},save:function(){this.$refs.customBaseTable.getData()}},computed:{dialogName:function(){return this.openDialogName},setApiObj:function(){return this.apiObj.params=Object.assign({},this.apiObj.params,this.searchObj),this.apiObj}},watch:{}}),r=a("KHd+"),u=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1000px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{staticStyle:{height:"50px"}},[a("el-row",{staticStyle:{"text-align":"center","padding-top":"20px"}},[a("el-col",{attrs:{span:5}},[t._v("客户名称："+t._s(t.temp.name))]),t._v(" "),a("el-col",{attrs:{span:5}},[t._v("客户类型："+t._s(t.temp.typeName))]),t._v(" "),a("el-col",{attrs:{span:5}},[t._v("地域："+t._s(t.temp.provinceName))]),t._v(" "),a("el-col",{attrs:{span:5}},[t._v("本次分摊总额："+t._s(t.temp.currentBalance))]),t._v(" "),a("el-col",{attrs:{span:1}},[a("el-button",{staticClass:"btns",staticStyle:{"font-size":"12px"},attrs:{type:"text"},on:{click:t.edit}},[t._v("修改")])],1)],1)],1),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[a("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[a("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px"}},[a("custom-base-table",{ref:"customBaseTable",attrs:{keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.setApiObj,tempData:t.temp,componentId:"customBaseTable",showAll:!1,useSummary:!0,customSummary:t.customSummary},on:{databridge:t.dataBridge,"custom-summary-value":t.customSummaryValue}})],1),t._v(" "),a("div",{staticStyle:{"text-align":"center","padding-bottom":"10px"}},[a("el-button",{on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogReceiptAdd.vue";e.default=u.exports},LspI:function(t,e,a){"use strict";var i=a("en8w");a.n(i).a},en8w:function(t,e,a){}}]);