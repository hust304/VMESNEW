(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-60a7","D2zt","cE6r"],{"BN3/":function(t,e,a){},D2zt:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf");var i=a("spKr");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{retreatId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){this.retreatId=this.initData.retreatId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){if(e){t.dialogLoading=!0;var a=t.$storage.get("userInfo").userName;Object(i.auditDisagreePurchaseRetreat)({retreatId:t.retreatId,remark:t.temp.remark,userName:a}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}})}}},s=a("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-form-item",{attrs:{label:"退回原因:",prop:"remark"}},[a("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogAuditDisagree.vue";e.default=l.exports},RxSU:function(t,e,a){"use strict";var i=a("BN3/");a.n(i).a},cE6r:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf"),a("Oyvg"),a("rGqo");var i=a("uTIz"),o=a("2+ib"),n=a("spKr");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{searchBar:i.a,multilevelTable:o.a},name:"dialog-add",props:["initData","visible"],data:function(){return{retreatId:"",supplierId:"",supplierName:"",totalSum:"",dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",table_style:"",orderId:"",orderDtlIds:"",supplierId:"",supplierName:""},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"sysCode",width:"200"},{columnIndex:"supplierName"},{columnIndex:"orderCode",width:"200"},{columnIndex:"cdate"},{columnIndex:"retreatDate"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待提交"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreat",params:{id:"",fieldCode:"sysCode,supplierName,orderCode,cdate,retreatDate,remark,state"}},tempData:{},showHeader:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreatDetail",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,price,amount"}},dynamicValue:{parentId:"self@id"},tempData:{},isSingle:!1,componentId:"twoLevelTable",useSummary:!0,customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 50%" class="inputStyle">\n                      <span>退货总额：</span>\n                      <span>\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="realityTotal">\n                            <el-input v-model="data.realityTotal" size="mini" placeholder="请输入"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    </ul>'},data:{realityTotal:""},boxStyle:{width:"500px",float:"left",padding:"10px"},computes:{realityTotal:"table@amount"}}}]}},created:function(){this.retreatId=this.initData.retreatId,this.supplierId=this.initData.supplierId,this.supplierName=this.initData.supplierName,null!=this.initData.totalSum&&(this.totalSum=this.initData.totalSum+""),this.tableConfigList[0].apiObj.params.id=this.retreatId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){this.rowTableList=[],Array.isArray(t)&&(this.rowTableList=t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},closeDialog:function(t){},findChildrenList:function(t){var e=[];return null!=t&&null!=t[0].children&&t[0].children.length>0&&t[0].children.forEach(function(t){e.push(t)}),e},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkNumber:function(t,e){var a="";return null==t||0==t.trim().length?a=e+"输入为空或空字符串！":null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())&&(a=e+"("+t+") 输入错误，请输入大于零的正整数或(1,2)位小数！"),a},save:function(){if(this.$refs.AuditPassDialog.getData(),null!=this.rowTableList&&this.rowTableList.length>0){var t=this.findChildrenList(this.rowTableList);this.auditPass(t)}},auditPass:function(t){var e=this,a=this.tableConfigList[1].customSummary.data.realityTotal;a+="";var i=this.checkNumber(a,"退货总额");if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{if(null!=this.totalSum&&this.totalSum.trim().length>0&&this.totalSum.trim(),a-this.totalSum>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:"退货总额("+a+") 不可大于退货明细总金额"});else if(null!=t&&0!=t.length){var o=[];t.forEach(function(t){var e={id:t.id,count:t.count,price:t.price,productId:t.productId,unitName:t.unitName,p2nFormula:t.p2nFormula};o.push(e)});var s="";null!=o&&o.length>0&&(s=JSON.stringify(o)),Object(n.auditPassPurchaseRetreat)({retreatId:this.retreatId,supplierId:this.supplierId,supplierName:this.supplierName,realityTotal:a,dtlJsonStr:s}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"无退货单明细数据！"})}}}},r=a("KHd+"),d=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.initData.dialog_width},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("el-row",{style:t.initData.table_style},[a("multilevel-table",{ref:"AuditPassDialog",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("通过")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)},[],!1,null,null,null);d.options.__file="dialogAuditPass.vue";e.default=d.exports},us7y:function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("2+ib"),o=a("uTIz"),n=a("cE6r"),s=a("D2zt"),l=(a("spKr"),a("Vobf")),r=(a("z0WU"),{components:{multilevelTable:i.a,searchBar:o.a,dialogAuditPass:n.default,dialogAuditDisagree:s.default},data:function(){return{searchList:[{label:"退货单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"},{label:"退货单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"1",label:"待审核"},{value:"2",label:"待退货"},{value:"3",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"制单日期起",type:"date",ruleType:"date",mapKey:"cdateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"制单日期止",type:"date",ruleType:"date",mapKey:"cdateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"sysCode",width:"200"},{columnIndex:"supplierName"},{columnIndex:"orderCode",width:"200"},{columnIndex:"cdate"},{columnIndex:"retreatDate"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待提交"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"通过",nameEn:"auditPassByParent",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.auditPassByParent},{name:"退回",nameEn:"auditDisagreeByParent",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.auditDisagreeByParent}]}],apiObj:{apiName:"listPageRetreat",params:{state:"1",orderStr:"retreat.cdate desc",fieldCode:"sysCode,supplierName,orderCode,cdate,retreatDate,remark,state"}},tempData:{},showHeader:!1,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"1",text:"待审核"},info2:{state:"2",text:"待退货"},info3:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageRetreatDetail",params:{isNeedPage:"false",fieldCode:"productCode,productName,productSpec,productGenreName,unitName,count,price,amount,remark,state"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",retreatId:"",supplierId:"",supplierName:"",totalSum:"",title:"",data:{},tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(l.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()}))},databridge:function(t){this.temp.dataList=t,this.selectList=t,this.configs.topBarBtnList.forEach(function(t){"orderSubmit"==t.nameEn&&(t.state=!1)});var e=!1;if(null!=t&&t.length>0)for(var a=0;a<t.length;a++){if("0"!=t[a].state){e=!0;break}}e&&this.configs.topBarBtnList.forEach(function(t){"orderSubmit"==t.nameEn&&(t.state=!0)})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},auditPassByParent:function(t,e){var a=.7*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var i=.75*(.618*a)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.retreatId=t.id,this.dialogData.supplierId=t.supplierId,this.dialogData.supplierName=t.supplierName,this.dialogData.totalSum=t.totalSum,this.dialogData.title="退货单审核",this.openDialogName="dialogAuditPass",this.showDialog=!0,this.visible=!0},auditDisagreeByParent:function(t,e){this.dialogData.retreatId=t.id,this.dialogData.title="审核退回",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),d=(a("RxSU"),a("KHd+")),u=Object(d.a)(r,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"saleOrder"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";e.default=u.exports}}]);