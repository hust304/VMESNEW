(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2d2c"],{"17/C":function(e,t,a){"use strict";var i=a("jGAm");a.n(i).a},"E3L/":function(e,t,a){"use strict";a.r(t);a("rGqo");var i=a("2+ib"),n=a("uTIz"),o=a("HeP5"),s=a("HSjz"),l=a("qBa6"),c=a("U4yN"),r=a("AV4t"),d=a("wMKg"),u=a("Vobf"),h={components:{multilevelTable:i.a,searchBar:n.a,dialogExecute:s.default,purchaseSignDtlQualityByInfo:l.default,addFinanceBillByPurchase:o.default,dialogListFinanceBill:c.default},data:function(){return{searchList:[{label:"签收单号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"签收单号"},{label:"采购单号",type:"input",ruleType:"string",mapKey:"orderCode",configs:{},placeholder:"采购单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商"},{label:"状态",type:"select",ruleType:"string",mapKey:"signState",configs:{clearable:!0,name:"",options:[{value:"",label:"全部"},{value:"1",label:"检验中"},{value:"2",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"是否质检",type:"select",ruleType:"string",mapKey:"quality",configs:{clearable:!0,name:"",options:[{value:"",label:"全部"},{value:"1",label:"免检"},{value:"2",label:"检验"}]},placeholder:"请选择"}],guid:"",searchObj:{},tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"扣款",nameEn:"addFinanceBillByParent",editBtns_isShow:!0,method:this.addFinanceBillByParent},{name:"扣款记录",nameEn:"findFinanceBillByParent",editBtns_isShow:!0,method:this.findFinanceBillByParent}]}],apiObj:{apiName:"listPagePurchaseSign",params:{fieldCode:"sysCode,orderCode,supplierName,signUserName,cdate,stateName",signState:"1",orderStr:"sign.cdate desc",dataType:this.$storage.get("dataType")}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"prodInfo",width:"200",_cellConfig:{hideTitle:!0}},{columnIndex:"orderUnitName",width:"80",_cellConfig:{hideTitle:!0}},{columnIndex:"price",width:"120",_cellConfig:{hideTitle:!0}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"免检",nameEn:"updateQualityByDetail",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.updateQualityByDetail},{name:"执行",nameEn:"executeByDetail",editBtns_isShow:!0,rowState:"#self@state#===1",method:this.executeByDetail},{name:"详情",nameEn:"signQualityInfoByDetail",editBtns_isShow:!0,rowState:"#self@state#==2 && #self@quality#==2",method:this.signQualityInfoByDetail}]}],apiObj:{apiName:"listPagePurchaseSignDetail",params:{fieldCode:"prodInfo,orderUnitName,qualityTypeName,price,arriveCount,qualityCount,badCount,retreatCount,receiveCount,stateName,signInCode,receiveInCode",prodColumnKey:"productCode,productName,productSpec,productProperty",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",detail_style:"",title:"",data:{},tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(u.initMenuButtons)({menuId:a,roleId:t}).then(function(t){e.$loading().close();var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)})),e.tableConfigList&&e.tableConfigList.forEach(function(e){e.customColumn&&e.customColumn.forEach(function(e){"last"==e.columnIndex&&e.component&&e.component.forEach(function(e){e.nameEn==t.nameEn&&(e.rowState="1==2")})})})})}).catch(function(t){e.$loading().close()}))},databridge:function(e){},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.selectList=[],this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},addFinanceBillByParent:function(e){this.dialogData.rowData=JSON.parse(JSON.stringify(e)),this.dialogData.title="扣款",this.openDialogName="addFinanceBillByPurchase",this.showDialog=!0,this.visible=!0},findFinanceBillByParent:function(e){this.dialogData.rowData=JSON.parse(JSON.stringify(e)),this.dialogData.title="扣款记录",this.openDialogName="dialogListFinanceBill",this.showDialog=!0,this.visible=!0},updateQualityByDetail:function(e){var t=this;this.$confirm("此操作将该记录变更为已完成, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(d.updateSignDetailByQuality)({signDtlId:e.id,roleId:t.$storage.get("userInfo").roleIds}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(e){})}).catch(function(){t.$message({type:"info",message:"已取消操作"})})},executeByDetail:function(e){var t=this;Object(r.checkExistQualityByProduct)({productId:e.productId}).then(function(a){null!=a.isExist&&"false"==a.isExist?t.$confirm("该货品无质检项，请在(质量-质检项设置)添加该货品质检项， 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.dialogData.rowData=e,t.dialogData.title="检验执行",t.openDialogName="dialogExecute",t.showDialog=!0,t.visible=!0}).catch(function(){t.$message({type:"info",message:"已取消执行"})}):(t.dialogData.rowData=e,t.dialogData.title="检验执行",t.openDialogName="dialogExecute",t.showDialog=!0,t.visible=!0)})},signQualityInfoByDetail:function(e){var t=.4*document.body.clientWidth;this.dialogData.dialog_width=t+"px",this.dialogData.signDtlId=e.id,this.dialogData.title="检验详情",this.openDialogName="purchaseSignDtlQualityByInfo",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},g=(a("IxZY"),a("17/C"),a("KHd+")),p=Object(g.a)(h,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"purchaseSignByQuality"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_quality_purchaseSignByQuality_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);p.options.__file="index.vue";t.default=p.exports},IxZY:function(e,t,a){"use strict";var i=a("tiHX");a.n(i).a},jGAm:function(e,t,a){},tiHX:function(e,t,a){}}]);