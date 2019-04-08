(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-403a"],{"7MTH":function(e,t,a){"use strict";a.r(t);a("f3/d");var i=a("sNnr"),l=a("2+ib"),o=(a("z0WU"),{components:{multilevelTable:l.a},name:"dialog-add",props:["initData","visible"],data:function(){var e=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.typeData.defaultSelected.length<=0?i(new Error("请选择出库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择接收单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tableData:[],selectList:[],configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"arrivingCount",width:150,componentName:"input",_cellConfig:{rules:[{lessThan:["self@count(-)self@arriveCount",!0]},{greaterThan:["0",!1]}],message:["须小于采购数量-到货数量","输入数量必须大于零"]}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{parentId:this.initData.temp.id,queryStr:" detail.count > detail.arrive_count ",fieldCode:"productCode,productName,spec,genre,unit,count,arriveCount,arrivingCount"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],typeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"warehouseInType",isglobal:"1",id:"d78ceba5beef41f5be16f0ceee775399"}},defaultSelected:["d78ceba5beef41f5be16f0ceee775399"]},WarehouseDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择仓库",tableUrl:"/warehouse/warehouseBase/listPageWarehouse",tableParm:{nodeId:"2d75e49bcb9911e884ad00163e105f05",queryStr:"a.layer = 2 and a.isdisable = '1' "},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择接收单位",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{type:"4"},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId,this.temp.makeName=e.userName,this.temp.deptName=this.initData.temp.supplierName,this.temp.deptId=this.initData.temp.supplierId},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},save:function(){this.getData(),this.signPurchaseOrder()},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},databridge:function(e){this.selectList=e},dialogClose:function(e){this.$emit("close-dialog",e||{})},typeSelect:function(e){this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"4"},this.temp.deptId=null,this.temp.deptName=null},warehouseSelect:function(e){e[0]&&(this.temp.warehouseId=e[0].id,this.temp.warehouseName=e[0].name)},deptSelect:function(e){e[0]&&(this.temp.deptId=e[0].id,this.temp.deptName=e[0].name)},makeSelect:function(e){e[0]&&(this.temp.makeId=e[0].id,this.temp.makeName=e[0].name)},closeDialog:function(e){this.showDialog=!1;null!=e.selectList&&e.selectList},signPurchaseOrder:function(){var e=this,t="";this.$refs.submitForm.validate(function(a){if(a){if(null==e.selectList||0==e.selectList.length)return void e.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"});for(var l=[],o=0;o<e.selectList.length;o++){var s=e.selectList[o],n={productId:"",count:"",remark:"",orderDetailId:""};n.productId=s.productId,n.count=s.arrivingCount,n.remark=s.remark,n.orderDetailId=s.id,l.push(n)}t=JSON.stringify(l),e.temp.dtlJsonStr=t,e.temp.orderId=e.initData.temp.id,null!=e.temp.type&&0!=e.temp.type.trim().length||(e.temp.type=e.typeData.defaultSelected[0]),e.dialogLoading=!0,Object(i.signPurchaseOrder)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}})}},watch:{}}),s=(a("a2Z7"),a("KHd+")),n=Object(s.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1300px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog,"table-selected":e.tableSelected}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"90px"}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"入库类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"仓库:",prop:"warehouseName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.WarehouseDialog.dialog},on:{callback:e.warehouseSelect},model:{value:e.temp.warehouseName,callback:function(t){e.$set(e.temp,"warehouseName",t)},expression:"temp.warehouseName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"来源单位:",prop:"deptName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.DeptDialog.dialog},on:{callback:e.deptSelect},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.MakeDialog.dialog},on:{callback:e.makeSelect},model:{value:e.temp.makeName,callback:function(t){e.$set(e.temp,"makeName",t)},expression:"temp.makeName"}})],1)],1)],1),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"500px",width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);n.options.__file="dialogSign.vue";t.default=n.exports},a2Z7:function(e,t,a){"use strict";var i=a("stqV");a.n(i).a},stqV:function(e,t,a){}}]);