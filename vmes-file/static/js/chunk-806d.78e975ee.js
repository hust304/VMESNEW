(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-806d","3+RD"],{"+kV4":function(t,e,i){"use strict";var a=i("jV77");i.n(a).a},"3+RD":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("2SRW");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{auditJsonStr:"",dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写审核原因",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},formTemp:[]}},created:function(){this.auditJsonStr=this.initData.temp.auditJsonStr},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.temp.auditExecuteJsonStr=this.auditJsonStr,this.$refs.submitForm.validate(function(e){e&&Object(a.auditDisagreeWarehouseCheckExecute)(t.temp).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){this.showDialog=!1}}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"不通过原因:",prop:"remark"}},[i("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogAuditDisagree.vue";e.default=l.exports},"9WTv":function(t,e,i){"use strict";i.d(e,"d",function(){return n}),i.d(e,"a",function(){return o}),i.d(e,"f",function(){return s}),i.d(e,"e",function(){return l}),i.d(e,"b",function(){return r}),i.d(e,"c",function(){return c});var a=i("t3Un");function n(t){return Object(a.a)({url:"/base/equipment/listPageEquipments",method:"post",data:t})}function o(t){return Object(a.a)({url:"/base/equipment/addEquipment",method:"post",data:t})}function s(t){return Object(a.a)({url:"/base/equipment/updateEquipment",method:"post",data:t})}function l(t,e){return Object(a.a)({url:"/base/equipment/update",method:"post",data:{id:t,isdisable:e}})}function r(t){return Object(a.a)({url:"/base/equipment/deleteByIds",method:"post",data:{ids:t}})}function c(t){return Object(a.a)({url:"/base/equipment/exportExcelEquipments",method:"post",responseType:"blob",data:{ids:t}})}},Cuvw:function(t,e,i){"use strict";var a=i("zo9M");i.n(a).a},jV77:function(t,e,i){},lZYi:function(t,e,i){"use strict";var a=i("wnxv");i.n(a).a},mtOT:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("zDZ1"),n=i("2+ib"),o=i("uTIz"),s=i("3+RD"),l=i("uXxI"),r=i("2SRW"),c=i("Vobf"),u=(i("z0WU"),{components:{dialogQrcode:a.a,multilevelTable:n.a,searchBar:o.a,dialogAuditDisagree:s.default},data:function(){return{searchList:[{label:"盘点单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"盘点单号"},{label:"盘点类型",type:"select",ruleType:"number",mapKey:"type",configs:{clearable:!0,name:"",options:[{value:"1",label:"按库位"},{value:"2",label:"按货品"}]},placeholder:"请选择"},{label:"盘点单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"未完成"},{value:"1",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"productGenreName",configs:{},placeholder:"货品属性"},{label:"计量单位",type:"input",ruleType:"string",mapKey:"productUnitName",configs:{},placeholder:"请输入计量单位"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"code"},{columnIndex:"typeName"},{columnIndex:"makeName"},{columnIndex:"cdate"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"未完成"}}}],apiObj:{apiName:"listPagewarehouseChecks",params:{orderStr:" parent.code desc ",isNeedExecutor:"true",queryStr:" detail.state in ('2','3') "}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},warning:{state:"1",text:"执行中"},danger:{state:"2",text:"审核中"},info:{state:"-1",text:"已取消"},default:{state:"0",text:"待派单"}}}],apiObj:{apiName:"findListByWarehouseCheckExecute",params:{isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"通过",nameEn:"auditPass",isShow:!0,state:!1,icon:"add",method:this.auditPass},{name:"不通过",nameEn:"auditDisagree",isShow:!0,state:!1,icon:"add",method:this.dialogAuditDisagree}],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:{auditJsonStr:""},tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(c.initMenuButtons)({menuId:i,roleId:e}).then(function(e){t.$loading().close();var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()}))},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},databridge:function(t){this.temp.detail=t,this.selectList=t,this.configs.topBarBtnList.forEach(function(t){-1!="auditPass,auditDisagree".indexOf(t.nameEn)&&(t.state=!1)});var e=!1;if(null!=t&&t.length>0)for(var i=0;i<t.length;i++){if("2"!=t[i].detailState){e=!0;break}}e&&this.configs.topBarBtnList.forEach(function(t){-1!="auditPass,auditDisagree".indexOf(t.nameEn)&&(t.state=!0)})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},checkUserRoleByWarehouseAudit:function(){var t=this,e=this.$storage.get("userInfo").roleIds;Object(l.checkUserRoleByWarehouseAudit)(e).then(function(e){t.updateData(t.searchObj)}).catch(function(t){})},auditPass:function(){var t=this,e=this.selectList;if(null!=e&&0!=e.length){var i=this.checkAudit(e);if(null!=i&&i.trim().length>0)return i+=" 请重新选择审核结果是(待审核)的记录！",void this.$message({type:"warning",duration:5e3,showClose:!0,message:i});this.$confirm("您勾选的(审核中)盘点明细将审核通过, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var i=[];null!=e&&e.length>0&&e.forEach(function(t){if(null!=t.detailState&&t.detailState.trim().length>0&&"2"==t.detailState.trim()){var e={id:"",parentId:"",detailId:"",stockCount:"",count:"",code:"",productId:"",warehouseId:""};e.id=t.id,e.parentId=t.parentId,e.detailId=t.detailId,e.stockCount=t.stockCount,e.count=t.count,e.code=t.code,e.productId=t.productId,e.warehouseId=t.warehouseId,i.push(e)}});var a=JSON.stringify(i);t.saveAuditPass(a)}).catch(function(){t.$message({type:"info",message:"已取消删除"})})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})},checkAudit:function(t){var e=0,i="";return t.forEach(function(t){var a="";if(null!=t.detailState&&t.detailState.trim().length>0&&(a=t.detailState.trim()),"3"==a)i=i+"第 "+(e+1)+" 行: 明细状态(已完成)，无需审核！";else if("2"==a){var n="";null!=t.state&&t.state.trim().length>0&&(n=t.state.trim(),-1!="2,3".indexOf(n)&&(i=i+"第 "+(e+1)+" 行: 明细已经审核，无需再次审核！"))}e+=1}),i},saveAuditPass:function(t){var e=this;Object(r.auditPassWarehouseCheckExecute)({auditExecuteJsonStr:t}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(t){})},dialogAuditDisagree:function(){var t=this.selectList;if(null!=t&&0!=t.length){var e=this.checkAudit(t);if(null!=e&&e.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:e});else{var i=[];null!=t&&t.length>0&&t.forEach(function(t){if(null!=t.detailState&&t.detailState.trim().length>0&&"2"==t.detailState.trim()){var e={id:"",parentId:"",detailId:""};e.id=t.id,e.parentId=t.parentId,e.detailId=t.detailId,i.push(e)}});var a=JSON.stringify(i);this.dialogData.temp.auditJsonStr=a,this.dialogData.title="盘点审核",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条明细！"})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),d=(i("Cuvw"),i("KHd+")),p=Object(d.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"warehouseCheckManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);p.options.__file="index.vue";e.default=p.exports},wnxv:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="http://web.deecoop.cn/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';t+="<style></style>",t+="</head><body >",t+=document.getElementById("printContent").innerHTML,t+="</body></html>";var e=window.open("","打印","");e.document.write(t),e.document.close(),e.focus(),e.print(),e.close()}}},o=(i("lZYi"),i("+kV4"),i("KHd+")),s=Object(o.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"69d6d795",null);s.options.__file="dialogQrcode.vue";e.a=s.exports},zo9M:function(t,e,i){}}]);