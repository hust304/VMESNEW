(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3ef8"],{K77I:function(e,t,i){"use strict";var s=i("z0WU");t.a={directives:{switchshadow:{inserted:function(e,t,i){var s=i.context;e.scrollHeight>e.offsetHeight?s.showBoxShadow=!0:s.showBoxShadow=!1},componentUpdated:function(e,t,i){var s=i.context;e.scrollHeight>e.offsetHeight?s.showBoxShadow=!0:s.showBoxShadow=!1}}},props:{},data:function(){return{showBoxShadow:!1,scaleNum:0,suid:""}},created:function(){this.suid=Object(s.b)()},mounted:function(){var e=this;setTimeout(function(t){console.log(e.scaleNum,e.suid)})},beforeDestroy:function(){this.suid&&this.removeDialogClass()},computed:{size:function(){return this.$store.getters.size},formItemWidth:function(){var e={};switch(this.size){case"mini":e.width="180px";break;case"small":e.width="200px";break;default:e.width="220px"}return e},createDialogStyle:function(){return".".concat(this.suid,"{\n        width: ").concat(this.scaleNum,"%;\n        height: ").concat(this.scaleNum,"%;\n        margin-top: ").concat((100-this.scaleNum)/2*this.$store.getters.systemInfo.offsetHeight/100,"px !important;\n      }")},computeDialogClass:function(){return this.setStyle(this.suid),this.suid}},methods:{setStyle:function(e){if(e){var t=document.getElementById(e);t&&t.remove(),(t=document.createElement("style")).setAttribute("id",e),document.head.appendChild(t),t.innerText=this.createDialogStyle}},removeDialogClass:function(){var e=document.getElementById(this.suid);e&&e.remove()}},watch:{}}},fFEi:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("f3/d"),i("rGqo"),i("yt8O"),i("XfO3"),i("9AAn");var s=i("AUoE");function a(e){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={components:{},name:"dialog-add",props:["initData","visible"],mixins:[i("K77I").a],data:function(){return{deliverId:"",customerId:"",deliverType:"send",deliverTypeNameKeyMap:new Map([["send","1"],["deliver","2"],["self","3"]]),isShowSend:!0,isShowDeliver:!1,isShowSelf:!1,dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{deliverId:"",type:"",makeId:"",makeName:"",deliverDate:new Date,waybillCompany:"",waybillCode:"",customeAddressId:"",custAddress:"",custAddressName:"",custMobile:"",carCode:"",remark:""},tempLable:{},tempNotEditable:{},rules:{makeName:[{required:!0,message:"请选择经办人",trigger:"change"}],deliverDate:[{required:!0,message:"请填写发货日期",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",fullscreen:!1,tempLable:null},formTemp:[],MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择经办人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}},CustAddressDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择收货地址",tableUrl:"/base/customeAddress/listPageCustomeAddress",tableParm:{customerId:"",fieldCode:"name,mobile,address"},temp:{}},dialogName:"dialogOption"}}}},created:function(){this.deliverId=this.initData.deliverId,this.customerId=this.initData.customerId,this.CustAddressDialog.dialog.data.tableParm.customerId=this.initData.customerId;var e=this.$storage.get("userInfo");null!=e.userId&&e.userId.trim().length>0&&(this.temp.makeId=e.userId.trim()),null!=e.userName&&e.userName.trim().length>0&&(this.temp.makeName=e.userName.trim())},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=a(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){this.isShowSend=!1,this.isShowDeliver=!1,this.isShowSelf=!1,"send"==this.deliverType?this.isShowSend=!0:"deliver"==this.deliverType?this.isShowDeliver=!0:"self"==this.deliverType&&(this.isShowSelf=!0)},makeSelect:function(e){e[0]&&(this.temp.makeId=e[0].id,this.temp.makeName=e[0].name)},custAddressSelect:function(e){e[0]&&(this.temp.customeAddressId=e[0].id,this.temp.custAddressName=e[0].name,this.temp.custMobile=e[0].mobile,this.temp.custAddress=e[0].address)},save:function(){var e=this;this.dialogLoading=!0,this.temp.deliverId=this.deliverId,this.temp.type=this.deliverTypeNameKeyMap.get(this.deliverType),Object(s.updateSaleDeliverByDeliverType)(this.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"保存成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})},closeDialog:function(e){this.showDialog=!1}}},l=i("KHd+"),r=Object(l.a)(o,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],staticStyle:{height:"90vh"},attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px",top:"10vh","custom-class":"listDeliverClass"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%"}},[i("el-form",{ref:"submitForm",staticStyle:{height:"calc(100% - 61px)",overflow:"hidden"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{padding:"20px 50px"},style:{"box-shadow":e.showBoxShadow?"0px 5px 10px -10px black":""}},[i("el-radio-group",{on:{change:e.radioChange},model:{value:e.deliverType,callback:function(t){e.deliverType=t},expression:"deliverType"}},[i("el-radio",{attrs:{label:"send"}},[e._v("发货")]),e._v(" "),i("el-radio",{attrs:{label:"deliver"}},[e._v("送货")]),e._v(" "),i("el-radio",{attrs:{label:"self"}},[e._v("客户自提")])],1)],1),e._v(" "),i("div",{directives:[{name:"switchshadow",rawName:"v-switchshadow"}],staticStyle:{height:"calc(100% - 58px)","overflow-y":"auto"}},[i("el-form-item",{attrs:{label:"经办人：",prop:"makeName"}},[i("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.MakeDialog.dialog},on:{callback:e.makeSelect},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"发货日期：",prop:"deliverDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"date",placeholder:"发货日期","value-format":"yyyy-MM-dd"},model:{value:e.temp.deliverDate,callback:function(t){e.$set(e.temp,"deliverDate",t)},expression:"temp.deliverDate"}})],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSend,expression:"isShowSend"}]},[i("el-form-item",{attrs:{label:"物流公司：",prop:"waybillCompany"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.waybillCompany,callback:function(t){e.$set(e.temp,"waybillCompany",t)},expression:"temp.waybillCompany"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"物流单号：",prop:"waybillCode"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.waybillCode,callback:function(t){e.$set(e.temp,"waybillCode",t)},expression:"temp.waybillCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"收货地址：",prop:"custAddress"}},[i("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.CustAddressDialog.dialog},on:{callback:e.custAddressSelect},model:{value:e.temp.custAddress,callback:function(t){e.$set(e.temp,"custAddress",t)},expression:"temp.custAddress"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"联系人：",prop:"custAddressName"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custAddressName,callback:function(t){e.$set(e.temp,"custAddressName",t)},expression:"temp.custAddressName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"手机号：",prop:"custMobile"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custMobile,callback:function(t){e.$set(e.temp,"custMobile",t)},expression:"temp.custMobile"}})],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowDeliver,expression:"isShowDeliver"}]},[i("el-form-item",{attrs:{label:"车牌号：",prop:"carCode"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.carCode,callback:function(t){e.$set(e.temp,"carCode",t)},expression:"temp.carCode"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"收货地址：",prop:"custAddress"}},[i("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.CustAddressDialog.dialog},on:{callback:e.custAddressSelect},model:{value:e.temp.custAddress,callback:function(t){e.$set(e.temp,"custAddress",t)},expression:"temp.custAddress"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"联系人：",prop:"custAddressName"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custAddressName,callback:function(t){e.$set(e.temp,"custAddressName",t)},expression:"temp.custAddressName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"手机号：",prop:"custMobile"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.custMobile,callback:function(t){e.$set(e.temp,"custMobile",t)},expression:"temp.custMobile"}})],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowSelf,expression:"isShowSelf"}]},[i("el-form-item",{attrs:{label:"车牌号：",prop:"carCode"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.carCode,callback:function(t){e.$set(e.temp,"carCode",t)},expression:"temp.carCode"}})],1)],1),e._v(" "),i("el-form-item",{attrs:{label:"备注：",prop:"remark"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},style:{"box-shadow":e.showBoxShadow?"0px -5px 10px -10px black":""},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogAdd.vue";t.default=r.exports}}]);