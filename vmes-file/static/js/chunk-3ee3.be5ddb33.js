(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3ee3"],{"7MTH":function(e,t,a){"use strict";a.r(t);a("f3/d");var i=a("sNnr"),s=a("2+ib"),o=a("K77I"),l=(a("z0WU"),{components:{multilevelTable:s.a},name:"dialog-add",mixins:[o.a],props:["initData","visible"],data:function(){return{rules:{warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"arrivingCount",width:150,componentName:"input",_cellConfig:{rules:[{lessThan:["self@count(-)self@arriveCount",!0]},{greaterThan:["0",!1]}],message:["须小于采购数量-到货数量","输入数量必须大于零"]}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{parentId:this.initData.temp.id,queryStr:"detail.state in ('2','3')",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,arrivingCount"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],WarehouseDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择仓库",tableUrl:"/warehouse/warehouseBase/listPageWarehouse",tableParm:{nodeId:"2d75e49bcb9911e884ad00163e105f05",queryStr:"a.layer = 2 and a.isdisable = '1' "},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择接收单位",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{type:"4"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId,this.temp.makeName=e.userName,this.temp.typeName="采购入库",this.temp.deptName=this.initData.temp.supplierName,this.temp.deptId=this.initData.temp.supplierId},mounted:function(){this.isVisible=this.visible,this.scaleNum=this.$refs.myDialog.scaleNum},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},save:function(){var e=this;this.selectList=[],this.$refs.customBaseTable.getData(),setTimeout(function(){e.signPurchaseOrder()},1e3)},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},databridge:function(e){this.selectList=e},dialogClose:function(e){this.$emit("close-dialog",e||{})},warehouseSelect:function(e){e[0]&&(this.temp.warehouseId=e[0].id,this.temp.warehouseName=e[0].name)},deptSelect:function(e){e[0]&&(this.temp.deptId=e[0].id,this.temp.deptName=e[0].name)},makeSelect:function(e){e[0]&&(this.temp.makeId=e[0].id,this.temp.makeName=e[0].name)},closeDialog:function(e){this.showDialog=!1;null!=e.selectList&&e.selectList},signPurchaseOrder:function(){var e=this,t="";this.$refs.submitForm.validate(function(a){if(a){if(null==e.selectList||0==e.selectList.length)return;for(var s=[],o=0;o<e.selectList.length;o++){var l=e.selectList[o],n={productId:l.productId,count:l.arrivingCount,price:l.price,remark:l.remark,orderDetailId:l.id,planDtlId:l.planId,planId:l.planParentId,unit:l.unit,p2nFormula:l.p2nFormula};s.push(n)}t=JSON.stringify(s),e.dialogLoading=!0,Object(i.signPurchaseOrder)({purchaseOrderId:e.initData.temp.id,supplierId:e.initData.temp.supplierId,supplierName:e.initData.temp.supplierName,warehouseId:e.temp.warehouseId,roleId:e.$storage.get("userInfo").roleIds,dtlJsonStr:t}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}})}},watch:{}}),n=a("KHd+"),r=Object(n.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],ref:"myDialog",attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,layoutType:4,"custom-class":e.computeDialogClass},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog,"table-selected":e.tableSelected}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%",display:"flex","flex-direction":"column",position:"relative"}},[a("el-form",{ref:"submitForm",staticStyle:{"padding-top":"10px","flex-shrink":"0"},attrs:{inline:"",rules:e.rules,model:e.temp,"label-position":"right","label-width":"90px",size:e.size}},[a("el-form-item",{attrs:{label:"入库类型:",prop:"typeName"}},[a("el-input",{style:e.formItemWidth,attrs:{disabled:!0},model:{value:e.temp.typeName,callback:function(t){e.$set(e.temp,"typeName",t)},expression:"temp.typeName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"仓库:",prop:"warehouseName"}},[a("base-input-option",{style:e.formItemWidth,attrs:{dialog:e.WarehouseDialog.dialog},on:{callback:e.warehouseSelect},model:{value:e.temp.warehouseName,callback:function(t){e.$set(e.temp,"warehouseName",t)},expression:"temp.warehouseName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"来源单位:",prop:"deptName"}},[a("el-input",{style:e.formItemWidth,attrs:{disabled:!0},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{style:e.formItemWidth,attrs:{dialog:e.MakeDialog.dialog},on:{callback:e.makeSelect},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{width:"96%","margin-left":"2%","flex-grow":"1",position:"relative"}},[a("div",{staticStyle:{position:"absolute",top:"0",left:"0",right:"0",bottom:"0"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)]),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogSign.vue";t.default=r.exports},K77I:function(e,t,a){"use strict";var i=a("z0WU");t.a={directives:{switchshadow:{inserted:function(e,t,a){var i=a.context;e.scrollHeight>e.offsetHeight?i.showBoxShadow=!0:i.showBoxShadow=!1},componentUpdated:function(e,t,a){var i=a.context;e.scrollHeight>e.offsetHeight?i.showBoxShadow=!0:i.showBoxShadow=!1}}},props:{},data:function(){return{showBoxShadow:!1,scaleNum:0,suid:""}},created:function(){this.suid=Object(i.b)()},mounted:function(){var e=this;setTimeout(function(t){console.log(e.scaleNum,e.suid)})},beforeDestroy:function(){this.suid&&this.removeDialogClass()},computed:{size:function(){return this.$store.getters.size},formItemWidth:function(){var e={};switch(this.size){case"mini":e.width="180px";break;case"small":e.width="200px";break;default:e.width="220px"}return e},createDialogStyle:function(){return".".concat(this.suid,"{\n        width: ").concat(this.scaleNum,"%;\n        height: ").concat(this.scaleNum,"%;\n        margin-top: ").concat((100-this.scaleNum)/2*this.$store.getters.systemInfo.offsetHeight/100,"px !important;\n      }")},computeDialogClass:function(){return this.setStyle(this.suid),this.suid}},methods:{setStyle:function(e){if(e){var t=document.getElementById(e);t&&t.remove(),(t=document.createElement("style")).setAttribute("id",e),document.head.appendChild(t),t.innerText=this.createDialogStyle}},removeDialogClass:function(){var e=document.getElementById(this.suid);e&&e.remove()}},watch:{}}}}]);