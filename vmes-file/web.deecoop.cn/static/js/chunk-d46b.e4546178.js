(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-d46b"],{BMxX:function(t,e,i){},DYX1:function(t,e,i){"use strict";var a=i("BMxX");i.n(a).a},UulW:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("o+uy"),s=i("3n4a"),r=i("Aw+t"),l=i("vLOd"),c=i("kKEA"),d=i("Vobf"),m=i("hZMg"),u=i("/a8v"),h=i("YQ/6"),p=i("iUVV"),y={components:{multilevelTable:n.a,searchBar:a.a,addPaymentRecord:o.default,backPaymentRecord:s.default,listPaymentRecord:r.default,listPaymentHistory:l.default,listSupplierPaymentBuild:c.default},data:function(){return{searchList:[{label:"供应商编码",type:"input",ruleType:"string",mapKey:"supplierCode",configs:{},placeholder:"供应商编码"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[{name:"结转",nameEn:"frontPaymentHistory",isShow:!0,icon:"add",method:this.frontPaymentHistory},{name:"反结转",nameEn:"backPaymentHistory",isShow:!0,icon:"add",method:this.backPaymentHistory}]},tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"付款",nameEn:"addPaymentRecord",editBtns_isShow:!0,icon:"reback",method:this.addPaymentRecord},{name:"退款",nameEn:"backPaymentRecord",editBtns_isShow:!0,icon:"reback",method:this.backPaymentRecord},{name:"付款记录",nameEn:"listPaymentRecord",editBtns_isShow:!0,icon:"reback",method:this.listPaymentRecord},{name:"历史查询",nameEn:"listPaymentHistory",editBtns_isShow:!0,icon:"reback",method:this.listPaymentHistory}]}],apiObj:{apiName:"listPagePurchasePaymentHistory",params:{dataType:this.$storage.get("dataType"),fieldCode:"supplierCode,supplierName,paymentPeriod,beginPlus,beginMinus,nowOrderSum,nowPaymentSum,endPlus,endMinus"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",rowData:{},title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(d.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})}),t.$loading().close()}).catch(function(e){t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t},updateData:function(t){this.$refs.customBaseTable.updateData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},frontPaymentHistory:function(){var t=this;Object(u.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){var i=e.initialPeriod.trim(),a=e.paymentPeriod.trim();a-i==0&&Object(h.checkIsAllBuildSupplierPayment)().then(function(e){null!=e.isAllBuild&&"false"==e.isAllBuild&&t.$confirm("当前付款期间("+a+")含有供应商期初值未设定, 是否进行设定?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e=.7*document.body.clientWidth;t.dialogData.dialog_width=e+"px";var i=.75*(.618*e)+"px";t.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",t.dialogData.title="供应商期初值设定",t.openDialogName="listSupplierPaymentBuild",t.showDialog=!0,t.visible=!0}).catch(function(){t.$message({type:"info",message:"已取设定"})})}).catch(function(t){}),Object(m.findSystemDateTime)({dateFormat:"yyyyMM"}).then(function(e){if(0==e.code&&null!=e.sysDateTime&&e.sysDateTime.trim().length>0){var i=e.sysDateTime.trim();if(a-i==0)return void t.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与当前自然月相同，不可结转操作！"});t.$confirm("付款期间("+a+") 将要执行结转操作，是否执行结转?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.$refs.customBaseTable.getData();var e=[];t.selectList.forEach(function(t){var i={supplierId:t.supplierId,paymentPeriod:t.paymentPeriod,beginPlus:t.beginPlus,beginMinus:t.beginMinus,beginValue:t.beginValue,nowOrderSum:t.nowOrderSum,nowPaymentSum:t.nowPaymentSum,endPlus:t.endPlus,endMinus:t.endMinus,endValue:t.endValue};e.push(i)});var i=JSON.stringify(e);Object(p.addPurchasePaymentHistory)({listJsonStr:i}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"结转成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消结转"})})}}).catch(function(t){})}}).catch(function(t){})},backPaymentHistory:function(){var t=this;Object(u.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){var i=e.initialPeriod.trim(),a=e.paymentPeriod.trim();if(a-i==0)return void t.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与该企业设定的初始付款期间相同，不可反结转操作！"});t.$confirm("付款期间("+a+") 将要执行反结转操作，是否执行反结转?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(p.backPurchasePaymentHistory)().then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"反结转成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消反结转"})})}})},addPaymentRecord:function(t,e){var i=this;Object(u.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){e.initialPeriod.trim();var a=e.paymentPeriod.trim();Object(m.findSystemDateTime)({dateFormat:"yyyyMM"}).then(function(e){if(0==e.code&&null!=e.sysDateTime&&e.sysDateTime.trim().length>0){var n=e.sysDateTime.trim();if(a-n!=0)return void i.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与当前自然月不相同，不可付款操作！"});i.dialogData.rowData={supplierId:t.supplierId,type:"1",paymentSum:"",supplierCode:t.supplierCode,supplierName:t.supplierName,endPlus:t.endPlus,endMinus:t.endMinus},i.dialogData.title="付款",i.openDialogName="addPaymentRecord",i.showDialog=!0,i.visible=!0}}).catch(function(t){})}})},backPaymentRecord:function(t,e){var i=this;Object(u.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){e.initialPeriod.trim();var a=e.paymentPeriod.trim();Object(m.findSystemDateTime)({dateFormat:"yyyyMM"}).then(function(e){if(0==e.code&&null!=e.sysDateTime&&e.sysDateTime.trim().length>0){var n=e.sysDateTime.trim();if(a-n!=0)return void i.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与当前自然月不相同，不可退款操作！"});i.dialogData.rowData={supplierId:t.supplierId,type:"2",paymentSum:"",supplierCode:t.supplierCode,supplierName:t.supplierName,nowPaymentSum:t.nowPaymentSum},i.dialogData.title="退款",i.openDialogName="backPaymentRecord",i.showDialog=!0,i.visible=!0}}).catch(function(t){})}})},listPaymentRecord:function(t,e){var i=.7*document.body.clientWidth;this.dialogData.dialog_width=i+"px";var a=.75*(.618*i)+"px";this.dialogData.table_style="height:"+a+";width: 96%;margin-left: 2%;",this.dialogData.supplierId=t.supplierId,this.dialogData.title="付款记录",this.openDialogName="listPaymentRecord",this.showDialog=!0,this.visible=!0},listPaymentHistory:function(t){var e=.7*document.body.clientWidth;this.dialogData.dialog_width=e+"px";var i=.75*(.618*e)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.rowData={supplierCode:t.supplierCode},this.dialogData.title="历史查询",this.openDialogName="listPaymentHistory",this.showDialog=!0,this.visible=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},g=(i("wlTy"),i("DYX1"),i("KHd+")),f=Object(g.a)(y,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"paymentManager"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_purchase_paymentManager_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);f.options.__file="index.vue";e.default=f.exports},aRol:function(t,e,i){},wlTy:function(t,e,i){"use strict";var a=i("aRol");i.n(a).a}}]);