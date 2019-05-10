(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-c903"],{"/EkP":function(e,t,a){"use strict";var i=a("NCx3");a.n(i).a},NCx3:function(e,t,a){},y4YF:function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf"),a("f3/d");var i=a("3d3b"),l=a("0UjI"),o=a("WIyV"),n=a("sNnr");a("qnVx"),a("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var s={components:{productTableDialog:i.a,definedTableDialog:l.a,customBaseTable:o.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{applyName:[{required:!0,message:"请选择申请人",trigger:"change"}],deptName:[{required:!0,message:"请选择申请部门",trigger:"change"}],supplierName:[{required:!0,message:"请选择供应商",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"",applyName:"",supplierName:"",deptName:"",applyId:"",supplierId:"",deptId:""},tempLable:{},tempQuery:{},tableData:[],tableList:[],rowData:{},selectList:null,configs:{topBarBtnList:[{name:"选择货品",nameEn:"addProduct",isShow:!0,icon:"add",method:this.addProduct},{name:"从计划导入",nameEn:"addPlan",isShow:!0,icon:"add",method:this.addPlan}]},apiObj:{apiName:"listPagePurchaseOrderDetails",params:{pageNo:1,parentId:"null",fieldCode:"productCode,productName,spec,genre,unit,count,price,amount,edate,reason,remark"}},customColumn:[{columnIndex:"unit",componentName:"select",_cellConfig:{asyn:{apiName:"findListProductUnitByProduct",params:{productId:""}},rules:[{required:!0}],outputData:!0}},{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"amount",componentName:"input",_cellConfig:{compute:"self@price(*)self@count",editable:!1}},{columnIndex:"price",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+([.]{1}[0-9]{1,2})?$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"reason",componentName:"select",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"purchaseReason",isglobal:"1"}},rules:[{required:!0}],outputData:!0}},{columnIndex:"edate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["tempData@minDate",!0]}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},tempData:{minDate:new Date},customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 100%"><span>合计金额：</span><span>￥{{data.total.toFixed(2)}}</span></li>\n                    <li style="float: left;width: 100%" class="inputStyle">\n                      <span>折扣金额：</span>\n                      <span>￥\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="discount" :rules="[{ type: \'number\', message: \'必须为数字值\'}]">\n                            <el-input v-model.number="data.discount" size="mini" placeholder="请输入"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    <li style="float: left;width: 100%"><span>订单金额：</span><span>￥{{(data.total-data.discount).toFixed(2)}}</span></li>\n                    </ul>'},data:{discount:"0.00",total:"0.00"},boxStyle:{width:"250px",float:"left",padding:"10px"},apiObj:{apiName:"",params:{}},computes:{total:"table@amount"}},ApplyDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择申请人",tableUrl:"/system/user/listPageUsers",tableParm:{isdisable:"1",fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择部门",treeUrl:"/system/department/treeDepartments",treeParm:{},tableUrl:"/system/department/listPageDepartments",tableParm:{isdisable:"1",fieldCode:"code,name,deptTypeName,layer,parentName,remark"},temp:{}},dialogName:"dialogTreeOption"}},SupplierDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择供应商",tableUrl:"/base/customer/listPageCustomers",tableParm:{isdisable:"1",genre:"49c0a7ebcb4c4175bd5195837a6a9a13",fieldCode:"code,name,typeName,remark,udate"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var e=this.$storage.get("userInfo");this.temp.applyId=e.userId,this.temp.applyName=e.userName,this.apiObj.params.parentId="null"},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){Array.isArray(e)?(this.tableList=[],this.tableList=e):(this.rowData=null,null!=e.row&&(this.rowData=e.row))},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},addProduct:function(){this.dialogData={title:"",data:null,tempLable:null},this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},addPlan:function(){this.dialogData={title:"",data:null,tempLable:null},this.dialogData.apiName="listPagePurchasePlanDetails",this.dialogData.fieldCode="code,productCode,productName,spec,genre,unit,count,edate,reason",this.dialogData.queryStr=" detail.id not in (select plan_id from vmes_purchase_order_detail where plan_id is not null and state != '-1' ) and detail.state = '2' ",this.dialogData.orderStr="product.code desc";this.dialogData.searchList=[{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"},{label:"计划单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入计划单号"}],this.dialogData.data=this.tableList,this.dialogData.title="选择货品",this.openDialogName="definedTableDialog",this.showDialog=!0,this.inLinVisible=!0},save:function(){var e=this;this.tableList=[],this.$refs.orderAddDialog.getData(),setTimeout(function(){e.saveOrder()},1e3)},saveOrder:function(){var e=this,t="";this.$refs.submitForm.validate(function(a){if(a){if(null==e.tableList||0==e.tableList.length)return;for(var i=[],l=0;l<e.tableList.length;l++){var o=e.tableList[l],r={productId:"",amount:"",unit:"",price:"",count:"",reason:"",edate:"",remark:"",planId:"",id:""};r.productId=o.productId,r.amount=o.amount,r.unit=o.unit,o.unit.item?r.unit=o.unit.item.id:r.unit=o.unitId,r.price=o.price,r.count=o.count,r.remark=o.remark,r.edate=o.edate,o.reason.item?r.reason=o.reason.item.id:r.reason=o.reasonId,r.planId=o.planId,r.id=o.id,i.push(r)}t=JSON.stringify(i),e.temp.discount=e.customSummary.data.discount,e.temp.total=e.customSummary.data.total,e.temp.amount=e.temp.total-e.temp.discount,e.temp.dtlJsonStr=t,e.dialogLoading=!0,Object(n.addPurchaseOrder)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){console.log(t),e.dialogLoading=!1})}})},deptSelect:function(e){e[0]&&(this.temp.deptId=e[0].id,this.temp.deptName=e[0].name)},applySelect:function(e){e[0]&&(this.temp.applyId=e[0].id,this.temp.applyName=e[0].name)},supplierSelect:function(e){e[0]&&(this.temp.supplierId=e[0].id,this.temp.supplierName=e[0].name)},closeDialog:function(e){this.showDialog=!1;var t=!1;null!=e.isConfirm&&(t=e.isConfirm);var a=[];null!=e.selectList&&(a=e.selectList),this.tableSelected(t,a)},tableSelected:function(e,t){if(e&&null!=t&&t.length>0)for(var a=0;a<t.length;a++){var i=t[a],l={productId:"",productCode:"",productName:"",spec:"",genre:"",unit:"",amount:"",price:"",count:"",reason:"",edate:"",remark:"",planId:"",id:""};null!=i.productId&&i.productId.trim().length>0?(l.productId=i.productId.trim(),l.planId=i.id.trim(),l.remark="从采购计划："+i.code+"导入",l.edate=i.edate,l.count=i.count,l.reason=i.reason,l.reasonId=i.reasonId,null!=i.productCode&&i.productCode.trim().length>0&&(l.productCode=i.productCode.trim()),null!=i.productName&&i.productName.trim().length>0&&(l.productName=i.productName.trim()),null!=i.spec&&i.spec.trim().length>0&&(l.spec=i.spec.trim()),null!=i.genre&&i.genre.trim().length>0&&(l.genre=i.genre.trim()),null!=i.unit&&i.unit.trim().length>0&&(l.unit=i.unit.trim(),l.unitId=i.unitId.trim())):(l.productId=i.id.trim(),null!=i.code&&i.code.trim().length>0&&(l.productCode=i.code.trim()),null!=i.name&&i.name.trim().length>0&&(l.productName=i.name.trim()),null!=i.spec&&i.spec.trim().length>0&&(l.spec=i.spec.trim()),null!=i.genreName&&i.genreName.trim().length>0&&(l.genre=i.genreName.trim()),null!=i.unitName&&i.unitName.trim().length>0&&(l.unit=i.unitName.trim(),l.unitId=i.unit.trim())),l.id=i.id.trim()||a,this.tableData.push(l)}}},watch:{}},d=(a("/EkP"),a("KHd+")),p=Object(d.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1250px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"申请人:",prop:"applyName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.ApplyDialog.dialog},on:{callback:e.applySelect},model:{value:e.temp.applyName,callback:function(t){e.$set(e.temp,"applyName",t)},expression:"temp.applyName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"申请部门:",prop:"deptName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.DeptDialog.dialog},on:{callback:e.deptSelect},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"供应商:",prop:"supplierName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:e.SupplierDialog.dialog},on:{callback:e.supplierSelect},model:{value:e.temp.supplierName,callback:function(t){e.$set(e.temp,"supplierName",t)},expression:"temp.supplierName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1),e._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state,dialog:e.dialog},on:{myclick:e.method}})]})],2)],1),e._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"400px",width:"96%","margin-left":"2%"}},[a("custom-base-table",{ref:"orderAddDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,tempData:e.tempData,componentId:"orderAddDialog",useDefaultBtn:!0,rowKey:"_insideId",showAll:!1,keyMapping:e.keyMapping,useSummary:!0,customSummary:e.customSummary},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogAdd.vue";t.default=p.exports}}]);