(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0077","chunk-403a","chunk-f940"],{"7MTH":function(e,t,a){"use strict";a.r(t);a("f3/d");var i=a("sNnr"),o=a("2+ib"),s=(a("z0WU"),{components:{multilevelTable:o.a},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.typeData.defaultSelected.length<=0?i(new Error("请选择出库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"arrivingCount",width:150,componentName:"input",_cellConfig:{rules:[{lessThan:["self@count(-)self@arriveCount",!0]},{greaterThan:["0",!1]}],message:["须小于采购数量-到货数量","输入数量必须大于零"]}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{parentId:this.initData.temp.id,queryStr:" detail.count > detail.arrive_count ",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,arrivingCount"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],typeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"warehouseInType",isglobal:"1",id:"d78ceba5beef41f5be16f0ceee775399"}},defaultSelected:["d78ceba5beef41f5be16f0ceee775399"]},WarehouseDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择仓库",tableUrl:"/warehouse/warehouseBase/listPageWarehouse",tableParm:{nodeId:"2d75e49bcb9911e884ad00163e105f05",queryStr:"a.layer = 2 and a.isdisable = '1' "},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择接收单位",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{type:"4"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId,this.temp.makeName=e.userName,this.temp.deptName=this.initData.temp.supplierName,this.temp.deptId=this.initData.temp.supplierId},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},save:function(){var e=this;this.selectList=[],this.$refs.customBaseTable.getData(),setTimeout(function(){e.signPurchaseOrder()},1e3)},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},databridge:function(e){this.selectList=e},dialogClose:function(e){this.$emit("close-dialog",e||{})},typeSelect:function(e){this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"4"},this.temp.deptId=null,this.temp.deptName=null},warehouseSelect:function(e){e[0]&&(this.temp.warehouseId=e[0].id,this.temp.warehouseName=e[0].name)},deptSelect:function(e){e[0]&&(this.temp.deptId=e[0].id,this.temp.deptName=e[0].name)},makeSelect:function(e){e[0]&&(this.temp.makeId=e[0].id,this.temp.makeName=e[0].name)},closeDialog:function(e){this.showDialog=!1;null!=e.selectList&&e.selectList},signPurchaseOrder:function(){var e=this,t="";this.$refs.submitForm.validate(function(a){if(a){if(null==e.selectList||0==e.selectList.length)return;for(var o=[],s=0;s<e.selectList.length;s++){var n=e.selectList[s],l={productId:"",count:"",remark:"",orderDetailId:""};l.productId=n.productId,l.count=n.arrivingCount,l.remark=n.remark,l.orderDetailId=n.id,o.push(l)}t=JSON.stringify(o),e.temp.dtlJsonStr=t,e.temp.orderId=e.initData.temp.id,null!=e.temp.type&&0!=e.temp.type.trim().length||(e.temp.type=e.typeData.defaultSelected[0]),e.dialogLoading=!0,Object(i.signPurchaseOrder)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}})}},watch:{}}),n=(a("a2Z7"),a("KHd+")),l=Object(n.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog,"table-selected":e.tableSelected}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"90px"}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"入库类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"仓库:",prop:"warehouseName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.WarehouseDialog.dialog},on:{callback:e.warehouseSelect},model:{value:e.temp.warehouseName,callback:function(t){e.$set(e.temp,"warehouseName",t)},expression:"temp.warehouseName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"来源单位:",prop:"deptName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.DeptDialog.dialog},on:{callback:e.deptSelect},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.MakeDialog.dialog},on:{callback:e.makeSelect},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1)],1),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"500px",width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogSign.vue";t.default=l.exports},"8yTc":function(e,t,a){},DBLT:function(e,t,a){},GjEI:function(e,t,a){"use strict";a.r(t);a("sNnr");var i=a("2+ib"),o=(a("z0WU"),{components:{multilevelTable:i.a},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.typeData.defaultSelected.length<=0?i(new Error("请选择出库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"signName"},{columnIndex:"sdate"},{columnIndex:"warehouseInCode"},{columnIndex:"remark"}],apiObj:{apiName:"listPagePurchaseSigns",params:{orderId:this.initData.temp.id,orderStr:" sign.cdate desc "}},tempData:{},showIndex:!0,showHeader:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"all",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[],apiObj:{apiName:"listPagePurchaseSignDetails",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}]}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId,this.temp.makeName=e.userName},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},databridge:function(e){this.selectList=e},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e){this.showDialog=!1;null!=e.selectList&&e.selectList}},watch:{}}),s=(a("uPfp"),a("KHd+")),n=Object(s.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog,"table-selected":e.tableSelected}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"90px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{height:"500px",width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);n.options.__file="dialogSignList.vue";t.default=n.exports},a2Z7:function(e,t,a){"use strict";var i=a("stqV");a.n(i).a},fKAa:function(e,t,a){"use strict";a.r(t);a("rGqo");var i=a("uTIz"),o=a("2+ib"),s=a("7MTH"),n=a("GjEI"),l=a("Vobf"),r=a("sNnr"),c=a("qnVx"),d={components:{multilevelTable:o.a,dialogSign:s.default,dialogSignList:n.default,searchBar:i.a},data:function(){return{searchList:[{label:"采购单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入采购单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"请输入供应商"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"采购中"},{value:"3",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"code"},{columnIndex:"supplierName"},{columnIndex:"applyName"},{columnIndex:"deptName"},{columnIndex:"amount"},{columnIndex:"cdate"},{columnIndex:"remark"},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"收货",nameEn:"sign",editBtns_isShow:!0,rowState:"#self@state#===2",icon:"sign",method:this.sign},{name:"取消",nameEn:"cancelRow",editBtns_isShow:!0,rowState:"#self@state#===0||#self@state#===2",icon:"cancelRow",method:this.cancel},{name:"收货详情",nameEn:"signList",editBtns_isShow:!0,icon:"signList",method:this.signList}]}],apiObj:{apiName:"listPagePurchaseOrders",params:{queryStr:"  purchaseOrder.state in ('2','3') ",orderStr:" purchaseOrder.code desc"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},info1:{state:"3",text:"部分签收"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"取消",nameEn:"cancelRow",editBtns_isShow:!0,rowState:"#self@state#===0||#self@state#===2",icon:"cancelRow",method:this.cancelRow}]}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(l.initMenuButtons)({menuId:a,roleId:t}).then(function(t){var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(console.log(e),e.isShow=!1)}))}),e.$loading().close()}).catch(function(t){console.log(t),e.$loading().close()}))},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(e)},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},cancel:function(e,t){var a=this,i=this;i.$confirm("此操作将该记录变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(r.cancelPurchaseOrder)(e.id).then(function(e){0===e.code&&(i.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),i.updateData(a.searchObj))}).catch(function(e){console.log(e)})}).catch(function(){i.$message({type:"info",message:"已取消操作"})})},cancelRow:function(e,t,a){var i=this,o=this;o.$confirm("此操作将该记录变更为已取消状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(c.cancelPurchaseOrderDetail)(e.id).then(function(e){0===e.code&&(o.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),o.updateData(i.searchObj))}).catch(function(e){console.log(e)})}).catch(function(){o.$message({type:"info",message:"已取消操作"})})},signList:function(e,t){this.dialogData.temp=e,this.dialogData.title="签收详情",this.openDialogName="dialogSignList",this.showDialog=!0,this.visible=!0},sign:function(e,t){this.dialogData.temp=e,this.dialogData.title="签收",this.openDialogName="dialogSign",this.showDialog=!0,this.visible=!0},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},u=(a("jWqT"),a("KHd+")),m=Object(u.a)(d,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"purchasePlan"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);m.options.__file="index.vue";t.default=m.exports},jWqT:function(e,t,a){"use strict";var i=a("DBLT");a.n(i).a},stqV:function(e,t,a){},uPfp:function(e,t,a){"use strict";var i=a("8yTc");a.n(i).a}}]);