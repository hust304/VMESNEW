(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-ce83"],{"3d3b":function(t,e,a){"use strict";a("rE2o"),a("ioFf"),a("91GP"),a("pIFo");var i=a("f/WR"),n=a("uTIz");a("xMja");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{transferTable:i.a,searchBar:n.a},name:"productTableDialog",props:["initData","visible"],data:function(){return{isConfirm:!1,temp:{productIds:""},tempLable:{},rules:{},guid:"",tempQuery:{},searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!0,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null},pageData:null,pageNo:1,btnList:[{name:"确定",isShow:!0,state:!0,method:this.toAddWarehouseIn},{name:"清空",icon:"refresh",state:!0,plain:!0,method:this.resetQuery,isShow:!0}],apiData:{apiName:"listPageProducts",params:{}},tableSelectList:[],stateBtnData:{},tableConfigs:{showIndex:!0},tempList:[]}},created:function(){var t="";if(null!=this.initData.data&&this.initData.data.length>0)for(var e=0;e<this.initData.data.length;e++){var a=this.initData.data[e];null!=a.productId&&a.productId.trim().length>0&&(t=t+a.productId+",")}this.temp.productIds=t;var i="";null!=this.initData.queryStr&&(i=this.initData.queryStr);var n="";n=null!=this.initData.fieldCode?this.initData.queryStr:"code,name,spec,unitName,genreName,stockCount,safetyCount,lockCount,productStockCount,cdate";var s="";s=null!=this.initData.orderStr?this.initData.queryStr:"prod.stock_count desc";var o=!0;null!=this.initData.isNeedRepeat&&(o=this.initData.isNeedRepeat),o||null!=t&&t.trim().length>0&&(i="prod.id not in ("+(t="'"+(t=t.substring(0,t.lastIndexOf(","))).replace(",","','")+"'")+")");var l="false";null!=this.initData.isNeedCustomerPrice&&this.initData.isNeedCustomerPrice&&(l="true");var r="";null!=this.initData.customerId&&this.initData.customerId.trim().length>0&&(r=this.initData.customerId.trim()),this.apiData.params={fieldCode:n,queryStr:i,orderStr:s,isNeedCustomerPrice:l,customerId:r,isdisable:"1"}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{tableHeight:function(){},dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.apiData.params=Object.assign({},t)},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{isConfirm:this.isConfirm,selectList:this.tempList})},toAddWarehouseIn:function(){this.isConfirm=!0,this.isVisible=!1},resetQuery:function(){this.$refs.trabsferTables.clearTableSelected()},tableSelected:function(t){this.tempList=t},closeDialog:function(t){this.showDialog=!1}}},l=a("KHd+"),r=Object(l.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"15px","margin-left":"10px"}},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px","margin-top":t.searchList.length?"10px":"0"}},[a("div",{staticStyle:{float:"left",width:"calc(100%)",height:"650px"}},[a("transfer-table",{ref:"trabsferTables",attrs:{tableConfigs:t.tableConfigs,btnList:t.btnList,stateBtn:t.stateBtnData,apiData:t.apiData},on:{"table-selected":t.tableSelected}})],1)])],1)],1)},[],!1,null,null,null);r.options.__file="productTableDialog.vue";e.a=r.exports},"6k2s":function(t,e,a){"use strict";a.r(e);a("yt8O"),a("RW0V"),a("rE2o"),a("ioFf"),a("f3/d"),a("Oyvg"),a("rGqo");var i=a("3d3b"),n=a("z9VH"),s=a("Q4qC"),o=a("z0WU"),l=a("mSNy");function r(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function c(t){return(c="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.deleteBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteBtns(scope.row,scope.$index)">删除</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.count" ></el-input>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-input v-model="scope.row.remark" ></el-input>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},h={components:{productTableDialog:i.a},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{rules:{typeName:[{required:!0,trigger:"change",validator:function(e,a,i){t.typeData.defaultSelected.length<=0?i(new Error("请选择入库类型")):i()}}],warehouseName:[{required:!0,trigger:"change",message:"请选择仓库"}],deptName:[{required:!0,message:"请选择来源单位",trigger:"change"}],makeName:[{required:!0,message:"请选择制单人",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,isNeedRepeat:!1,tempLable:null},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{type:"",typeName:"",warehouseId:"",warehouseName:"",deptId:"",deptName:"",makeId:"",makeName:"",dtlJsonStr:""},tempLable:{},tempQuery:{},tableData:[],selectList:null,initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:d,deleteBtns:this.deleteBtns,deleteBtns_isShow:!0}},configs:{topBarBtnList:[{name:"选择货品",nameEn:"add",isShow:!0,icon:"add",method:this.addProduct}],tableConfigs:[],showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1,typeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"warehouseInType",isglobal:"1"}},defaultSelected:["2c4a104aedc046848455f5fa6e3da87c"]},WarehouseDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择仓库",tableUrl:"/warehouse/warehouseBase/listPageWarehouse",tableParm:{nodeId:"2d75e49bcb9911e884ad00163e105f05",queryStr:"a.layer = 2 and a.isdisable = '1' "},temp:{}},dialogName:"dialogOption"}},DeptDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择来源单位",tableUrl:"/base/departmentCustomer/listPageDepartmentCustomer",tableParm:{},temp:{}},dialogName:"dialogOption"}},MakeDialog:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择制单人",tableUrl:"/system/user/listPageUsers",tableParm:{fieldCode:"code,name,mobile,email,deptName,remark"},temp:{}},dialogName:"dialogOption"}}}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId,this.temp.makeName=t.userName,this.initTable("add",""),this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"1"}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=c(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.k)(t.result),a=this.addTableTitle(e);this.configs.tableConfigs=a,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var a in t){var i=t[a];i.indexOf("_")>0&&("en"==l.a.locale?i=i.substring(i.indexOf("_")+1):"zh"==l.a.locale&&(i=i.substring(0,i.indexOf("_")))),e.tempLable[a]=i}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==l.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==l.a.locale&&(t.label=e.substring(0,e.indexOf("_")))),"count"===t.prop&&(t.component=u),"remark"===t.prop&&(t.component=p)}),this.internationalConfig(),t.push(this.initConfigs.tableOperates),t},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},initTable:function(t,e){var a=this;this.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(s.listPageDetailProduct)(function(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{},i=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(a).filter(function(t){return Object.getOwnPropertyDescriptor(a,t).enumerable}))),i.forEach(function(e){r(t,e,a[e])})}return t}({},this.tempQuery,{type:t,parentId:e,pageNo:this.pageNo})).then(function(t){a.getListPage(t),a.$loading().close()}).catch(function(t){a.$loading().close()})},dataBridge:function(t){},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},addProduct:function(){this.dialogData.data=this.tableData,this.dialogData.isNeedRepeat=!1,this.dialogData.title="选择货品",this.openDialogName="productTableDialog",this.showDialog=!0,this.inLinVisible=!0},deleteBtns:function(t,e){this.tableData.splice(e,1)},checkColumn:function(t){for(var e="",a=0;a<t.length;a++){var i=t[a].count;if(null==i||0==i.trim().length)e=e+"第 "+(a+1)+" 行: 入库数量为空或空字符串！";else new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(i)||(e=e+"第 "+(a+1)+" 行: 入库数量("+i+")输入错误，请输入大于零的正整数或(1,2)位小数！")}return e},saveWarehouseIn:function(){var t=this,e="";if(null!=this.tableData&&0!=this.tableData.length){var a=this.checkColumn(this.tableData);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{for(var i=[],s=0;s<this.tableData.length;s++){var o=this.tableData[s],l={productId:"",count:"",remark:""};l.productId=o.productId,l.count=o.count,l.remark=o.remark,i.push(l)}e=JSON.stringify(i),this.temp.dtlJsonStr=e,null!=this.temp.type&&0!=this.temp.type.trim().length||(this.temp.type=this.typeData.defaultSelected[0]),this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(n.addWarehouseIn)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){}))})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},typeSelect:function(t){this.temp.deptId="",this.temp.deptName="",t[0]?(this.temp.type=t[0],this.typeData.defaultSelected=[t[0]]):(this.temp.type=[],this.typeData.defaultSelected=[]);var e=this.temp.type;-1!="2c4a104aedc046848455f5fa6e3da87c,8e35209f19804e94940f076c8d71b955".indexOf(e)?(this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"1"}):-1!="d78ceba5beef41f5be16f0ceee775399,064dda15d44d4f8fa6330c5c7e46300e".indexOf(e)?(this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"4"}):-1!="81907167d5c8498692e6c4f3694c5cfa".indexOf(e)?(this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"3"}):-1!="80ac00503a1d41e5926be50f93c32c54".indexOf(e)&&(this.DeptDialog.dialog.data.tableUrl="/base/departmentCustomer/listPageDepartmentCustomer",this.DeptDialog.dialog.data.tableParm={type:"2"})},warehouseSelect:function(t){t[0]&&(this.temp.warehouseId=t[0].id,this.temp.warehouseName=t[0].name)},deptSelect:function(t){t[0]&&(this.temp.deptId=t[0].id,this.temp.deptName=t[0].name)},makeSelect:function(t){t[0]&&(this.temp.makeId=t[0].id,this.temp.makeName=t[0].name)},closeDialog:function(t){this.showDialog=!1;var e=!1;null!=t.isConfirm&&(e=t.isConfirm);var a=[];null!=t.selectList&&(a=t.selectList),this.tableSelected(e,a)},tableSelected:function(t,e){if(t&&null!=e&&e.length>0)for(var a=0;a<e.length;a++){var i=e[a],n={productId:"",productCode:"",productName:"",productSpec:"",productGenreName:"",productUnitName:"",count:"",stateName:"待派单",remark:""};n.productId=i.id.trim(),null!=i.code&&i.code.trim().length>0&&(n.productCode=i.code.trim()),null!=i.name&&i.name.trim().length>0&&(n.productName=i.name.trim()),null!=i.spec&&i.spec.trim().length>0&&(n.productSpec=i.spec.trim()),null!=i.genreName&&i.genreName.trim().length>0&&(n.productGenreName=i.genreName.trim()),null!=i.unitName&&i.unitName.trim().length>0&&(n.productUnitName=i.unitName.trim()),this.tableData.push(n)}}},watch:{pageNo:function(){this.initTable("add","")}}},g=(a("SlmE"),a("KHd+")),m=Object(g.a)(h,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"900px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"入库类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:t.typeData.data},on:{callback:t.typeSelect},model:{value:t.typeData.defaultSelected,callback:function(e){t.$set(t.typeData,"defaultSelected",e)},expression:"typeData.defaultSelected"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"仓库:",prop:"warehouseName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.WarehouseDialog.dialog},on:{callback:t.warehouseSelect},model:{value:t.temp.warehouseName,callback:function(e){t.$set(t.temp,"warehouseName",e)},expression:"temp.warehouseName"}})],1)],1)],1),t._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"来源单位:",prop:"deptName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.DeptDialog.dialog},on:{callback:t.deptSelect},model:{value:t.temp.deptName,callback:function(e){t.$set(t.temp,"deptName",e)},expression:"temp.deptName"}})],1)],1),t._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("base-input-option",{staticStyle:{width:"200px"},attrs:{dialog:t.MakeDialog.dialog},on:{callback:t.makeSelect},model:{value:t.temp.makeName,callback:function(e){t.$set(t.temp,"makeName",e)},expression:"temp.makeName"}})],1)],1)],1),t._v(" "),a("el-row",{staticStyle:{"margin-left":"2%","margin-bottom":"10px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2),t._v(" "),a("el-row",{staticClass:"tableContent",staticStyle:{height:"500px",width:"96%","margin-left":"2%"}},[a("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.saveWarehouseIn}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);m.options.__file="dialogAdd.vue";e.default=m.exports},Gla6:function(t,e,a){},SlmE:function(t,e,a){"use strict";var i=a("Gla6");a.n(i).a},XkgR:function(t,e,a){"use strict";var i=a("q2Tj");a.n(i).a},"f/WR":function(t,e,a){"use strict";a("XfO3"),a("HEwt"),a("a1Th"),a("rE2o"),a("ioFf"),a("dRSK"),a("rGqo"),a("91GP");var i=a("z0WU"),n=a("Yfch");function s(t){return function(t){if(Array.isArray(t))return t}(t)||function(t){if(Symbol.iterator in Object(t)||"[object Arguments]"===Object.prototype.toString.call(t))return Array.from(t)}(t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance")}()}var o={props:["colConfig","fixed"],template:'<el-table-column :label="colConfig.label" :fixed="fixed" :sortable="colConfig.sortable" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t  <template v-for="(item, index) in colConfig.rowMethods">\n    \t\t\t\t\t    <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="item.method(scope.row,scope.$index)" v-text="item.name"></el-button>\n                </template>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},l={components:{},name:"transfer-table",props:{tableConfigs:{type:Object,default:function(){return{}}},btnList:{type:Array,default:function(){return[]}},upTableBtnTemplate:{type:Array,default:function(){return[]}},downTableBtnTemplate:{type:Array,default:function(){return[]}},apiData:{type:Object,default:function(){return{}}},stateBtn:{type:Object,default:function(){return{}}}},data:function(){return{btnsBoxHeight:0,currentpage:1,tableLoading:!1,tableData:[],resultTableData:[],titleList:[],pageData:{},tableBtns:{columnIndex:"last",prop:"operate",label:"操作",component:o,rowMethods:[{name:"删除",method:this.deleteRow}]},rowKey:"",tempSelectList:[],stateBtnChecked:!1}},computed:{setTablesHeight:function(){return this.stateBtn.title?{height:"calc(50% - 15px)"}:{height:"calc(50% - 6px)"}},setResultBtnState:function(){var t=this;return function(e){return!t.resultTableData.length&&e.state}},setTableConfigs:function(){var t=s(this.titleList).slice(0);return{titleList:this.addTableTitle(t,this.upTableBtnTemplate),showIndex:void 0!==this.tableConfigs.showIndex&&this.tableConfigs.showIndex,isSingle:void 0!==this.tableConfigs.isSingle&&this.tableConfigs.isSingle,isSortable:void 0!==this.tableConfigs.isSortable&&this.tableConfigs.isSortable}},setResultTableConfigs:function(){var t=s(this.titleList).slice(0);return this.downTableBtnTemplate.length?this.addTableTitle(t,this.downTableBtnTemplate):this.addTableTitle(t,[this.tableBtns])},setResultTableData:function(){return[].concat(this.resultTableData)}},watch:{currentpage:function(){var t=Object.assign({},this.apiData.params);t.pageNo=this.currentpage,this.httpTableMethod(this.apiData.apiName,t)},setResultTableData:function(){this.$emit("table-selected",this.setResultTableData)},stateBtnChecked:function(){var t={};t[this.stateBtn.keyName?this.stateBtn.keyName:"isShow"]=this.stateBtnChecked,this.httpTableMethod(this.apiData.apiName,this.apiData.params,t)},"apiData.params":function(){console.log(this.apiData.params),this.httpTableMethod(this.apiData.apiName,this.apiData.params)}},created:function(){this.apiData.apiName?(this.httpTableMethod(this.apiData.apiName,this.apiData.params),this.rowKey=this.tableConfigs.rowKey||"id"):this.$message({message:"没有设置接口名",type:"error",duration:1e4})},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.$refs.btnsBox.clientHeight+5})},methods:{clearTableSelected:function(){var t=this;this.resultTableData=[],this.tempSelectList=[],this.tableData.forEach(function(e){t.$refs.selectTable.$refs.baseTable.clearSelection()})},httpTableMethod:function(t,e,a){var i=this;this.tableLoading=!0,this.$api[t](Object.assign({},e,a)).then(function(t){console.log(t),i.getListPage(t),i.tableLoading=!1}).catch(function(t){i.tableLoading=!1})},getListPage:function(t){var e=this;t&&(t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData,this.titleList=Object(i.k)(t.result),this.pageData=t.result.pageData,this.tableData=t.result.varList||[],this.tempSelectList=[],this.$nextTick(function(t){e.toggleRowSelected()}))},toggleRowSelected:function(){var t=this;this.tableData.forEach(function(e){t.resultTableData.some(function(a){return e[t.rowKey]===a[t.rowKey]})?(t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!0),!t.tempSelectList.some(function(a){return a[t.rowKey]===e[t.rowKey]})&&t.tempSelectList.push(e)):t.$refs.selectTable&&t.$refs.selectTable.$refs.baseTable.toggleRowSelection(e,!1)})},addTableTitle:function(t,e){return e&&e.length&&e.forEach(function(e){Object(n.a)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},dataBridge:function(t,e){this.getChecked(e,t)?this.addRowData(e):this.removeRowData(e)},resultDataBridge:function(t,e){console.log(t),console.log(e)},deleteRow:function(t,e){var a=this;console.log(t),console.log(e),this.resultTableData.find(function(e,i){if(t[a.rowKey]===e[a.rowKey])return a.resultTableData.splice(i,1),e}),this.toggleRowSelected()},updateView:function(t,e){this.resultTableData.splice(e-1,1,t)},getChecked:function(t,e){var a=this;return t?e.some(function(e){return t[a.rowKey]===e[a.rowKey]}):(e.length&&(this.tempSelectList=e),!!e.length)},addRowData:function(t){var e=this;t?!this.resultTableData.some(function(a){return t[e.rowKey]===a[e.rowKey]})&&this.resultTableData.push(t):this.addAllRowData()},addAllRowData:function(){var t=this;this.resultTableData.length?this.tempSelectList.forEach(function(e){t.addRowData(e)}):this.resultTableData=this.tempSelectList},removeRowData:function(t){var e=this;t?this.resultTableData.some(function(a,i){if(t[e.rowKey]===a[e.rowKey])return e.resultTableData.splice(i,1),!0}):this.tableData.forEach(function(t){e.removeRowData(t)})}}},r=(a("XkgR"),a("KHd+")),c=Object(r.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{height:"100%",padding:"10px"}},[t.stateBtn.title?a("div",{staticStyle:{"text-align":"right"}},[a("el-checkbox",{model:{value:t.stateBtnChecked,callback:function(e){t.stateBtnChecked=e},expression:"stateBtnChecked"}},[t._v(t._s(t.stateBtn.title))])],1):t._e(),t._v(" "),a("div",{style:t.setTablesHeight},[a("base-table",{directives:[{name:"loading",rawName:"v-loading",value:t.tableLoading,expression:"tableLoading"}],ref:"selectTable",attrs:{data:t.tableData,colConfigs:t.setTableConfigs.titleList,showCheckBox:!0,showIndex:t.setTableConfigs.showIndex,pageData:t.pageData,currentpage:t.currentpage,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{"update:currentpage":function(e){t.currentpage=e},databridge:t.dataBridge}})],1),t._v(" "),a("div",{staticStyle:{height:"11px"}}),t._v(" "),a("div",{ref:"resultBox",staticStyle:{position:"relative"},style:t.setTablesHeight},[a("div",{staticStyle:{height:"100%"},style:{paddingBottom:t.btnsBoxHeight+"px"}},[a("base-table",{ref:"resultTable",attrs:{data:t.setResultTableData,colConfigs:t.setResultTableConfigs,showCheckBox:!1,showIndex:t.setTableConfigs.showIndex,isSingle:t.setTableConfigs.isSingle,isSortable:t.setTableConfigs.isSortable,isFixed:1},on:{databridge:t.resultDataBridge}})],1),t._v(" "),a("div",{ref:"btnsBox",staticStyle:{position:"absolute",bottom:"0",right:"0"}},[t.btnList.length?[t._l(t.btnList,function(e,i){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],key:i,attrs:{name:e.name,icon:e.icon,plain:e.plain,state:t.setResultBtnState(e)},on:{myclick:e.method}})]})]:t._e()],2)])])},[],!1,null,"d9fe0b9e",null);c.options.__file="index.vue";e.a=c.exports},q2Tj:function(t,e,a){}}]);