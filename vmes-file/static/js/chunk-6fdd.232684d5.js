(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6fdd","chunk-7167"],{"F4/0":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d"),i("Oyvg");var a=i("uTIz"),n=i("2+ib"),o=i("YcSE"),s=i("b5Ov");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var r={components:{searchBar:a.a,multilevelTable:n.a,dialogWarehouseBySimple:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{sourceWarehouseId:"",warehouse:{name:null,id:null},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},resState:"",openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{warehouseIds:"",title:"",dialog_width:"",table_style:"",temp:{}},rowTableList:[],tableConfigList:[{customColumn:[{columnIndex:"moveCount",componentName:"input",_cellConfig:{}}],apiObj:{apiName:"listPageWarehouseInitial",params:{productIds:"",fieldCode:"pathName,productCode,productName,productSpec,productGenreName,productUnitName,stockCount,moveCount"}},tempData:{},showHeader:!0,showIndex:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){this.sourceWarehouseId=this.initData.sourceWarehouseId;var e="";null!=this.initData.productIds&&this.initData.productIds.trim().length>0&&(e=this.initData.productIds.trim()),this.tableConfigList[0].apiObj.params.productIds=e},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},updateData:function(e){this.$refs.customBaseTable.updateData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},closeDialog:function(e){"{}"!=JSON.stringify(e)&&(this.warehouse.id=e.id,this.warehouse.name=e.pathName),this.inLinVisible=!1,this.showDialog=!1},selectWarehouse:function(){var e=this.sourceWarehouseId;this.dialogData.warehouseIds=e,this.dialogData.title="选择库位",this.openDialogName="dialogWarehouseBySimple",this.showDialog=!0,this.inLinVisible=!0},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkValueNumber:function(e,t){var i="";return null==e||0==e.trim().length?i=t+"为空或空字符串！":null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())&&(i=t+"("+e+")输入错误，请输入大于零的正整数或(1,2)位小数！"),i},checkColumn:function(e){for(var t="",i=0;i<e.length;i++){var a=e[i],n="";null!=a.moveCount&&a.moveCount.trim().length>0&&(n=a.moveCount.trim()+"");var o="0";null!=a.stockCount&&a.stockCount.trim().length>0&&(o=a.stockCount.trim()+"");var s=this.checkValueNumber(n,"移库数量");null!=s&&s.trim().length>0?t=t+"第 "+(i+1)+" 行: "+s:n-o>0&&(t=t+"第 "+(i+1)+" 行: 移库数量不可大于库存数量！")}return t},save:function(){var e=this;if(null!=this.warehouse.name&&0!=this.warehouse.name.trim().length)if(this.$refs.customBaseTable.getData(),null!=this.rowTableList&&0!=this.rowTableList.length){var t=this.checkColumn(this.rowTableList);if(null!=t&&t.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:t});else{var i=[];this.rowTableList.forEach(function(e){var t={warehouseProductId:e.id,count:e.moveCount};i.push(t)});var a="";i.length>0&&(a=JSON.stringify(i)),Object(s.addWarehouseMoveBySimple)({targetWarehouseId:this.warehouse.id,dtlJsonStr:a}).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"无盘点货品信息！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择目标仓库，目标仓库为必填项不可为空！"})}}},u=i("KHd+"),c=Object(u.a)(r,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("el-row",{staticStyle:{width:"300px","margin-top":"15px","margin-left":"2%"}},[i("b",[e._v("目标仓库:")]),e._v(" "),i("el-input",{attrs:{value:e.warehouse.name,placeholder:"请选择",disabled:!0,clearable:!0}},[i("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:e.selectWarehouse},slot:"append"})],1)],1),e._v(" "),i("el-row",{style:e.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)},[],!1,null,null,null);c.options.__file="dialogAdd.vue";t.default=c.exports},IfZh:function(e,t,i){"use strict";i.d(t,"b",function(){return n}),i.d(t,"a",function(){return o}),i.d(t,"c",function(){return s});var a=i("t3Un");function n(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/listPageWarehouseInDetail",method:"post",data:e})}function o(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/findWarehouseListByWarehouseIn",method:"post",data:e})}function s(e){return Object(a.a)({url:"/warehouse/warehouseInDispatch/updateWarehouseInDispatch",method:"post",data:e})}},"T/cP":function(e,t,i){"use strict";var a=i("xQNa");i.n(a).a},YcSE:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("K3g7"),n=i("IfZh"),o=i("z0WU"),s=i("mSNy");function l(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var u={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{queryType:null,productId:"",productType:"",warehouseIds:"",dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1,resState:null}},created:function(){var e=this.initData.temp;this.productId=e.productId,this.productType=e.productType,this.warehouseIds=this.initData.warehouseIds,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name},this.pageNo=1,this.radioChange()},initTree:function(){var e=this;this.dialogLoading=!0;var t=this;Object(a.treeWarehouse)({isSimple:"Y",notInWarehouseIds:this.warehouseIds}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,name:a.name},i.push(a),t.treeData=i,t.initTable(null,null,null,null,null),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(t){e.dialogLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(o.m)(e.result),i=this.addTableTitle(t);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var i in e){var a=e[i];a.indexOf("_")>0&&("en"==s.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==s.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[i]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==s.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==s.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},initTable:function(e,t,i,a,o){var s=this;null!=t&&0!=t.trim().length||(t=""),null!=i&&0!=i.trim().length||(i=""),null!=a&&0!=a.trim().length||(a=""),null!=o&&0!=o.trim().length||(o=""),e&&(this.BaseTableLoading=!0),Object(n.a)(function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),a.forEach(function(t){l(e,t,i[t])})}return e}({},this.tempQuery,{isSimple:"Y",notInWarehouseIds:this.warehouseIds,nodeId:t,productId:i,productType:a,isExistProd:o,pageNo:this.pageNo})).then(function(t){s.getListPage(t),s.dialogLoading=!1,e&&(s.BaseTableLoading=!1)}).catch(function(e){s.dialogLoading=!1,s.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){var e="",t="",i="";"productId"==this.queryType?(e=this.productId,i="true"):"productType"==this.queryType?(t=this.productType,i="true"):"warehouseId"==this.queryType&&(i="false");var a="";null!=this.selectTree&&null!=this.selectTree.id&&this.selectTree.id.trim().length>0&&(a=this.selectTree.id.trim()),this.initTable(!0,a,e,t,i)},dataBridge:function(e){if(null!=e&&e.length>0){var t=e[0];t.pageName="dialogChangeWarehouseByIn",this.selectList.push(t)}},save:function(){var e={id:this.selectList[0].id,pathName:this.selectList[0].pathName};this.dialogClose(e),this.isVisible=!1}},watch:{pageNo:function(){this.initTable()}}},c=(i("T/cP"),i("KHd+")),d=Object(c.a)(u,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),i("el-col",{attrs:{span:20}},[i("div",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[i("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),i("el-row",{staticStyle:{height:"100px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogWarehouseBySimple.vue";t.default=d.exports},xQNa:function(e,t,i){}}]);