(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7586","chunk-35c4","chunk-776f","chunk-776f0","chunk-776f0a"],{T8OQ:function(e,t,a){"use strict";a.r(t);a("yt8O"),a("RW0V"),a("rE2o"),a("ioFf"),a("rGqo"),a("f3/d");var i=a("K3g7"),n=a("z0WU"),o=a("mSNy");function r(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var s={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{productId:"",queryType:null,dialogLoading:!1,isVisible:!1,inDialog:!0,tempLable:{},tempQuery:{},rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},BaseTableLoading:!1,tableData:[],selectList:[],configs:{tableConfigs:[],isSingle:!0,showCheckBox:!1,showIndex:!1},pageData:null,pageNo:1}},created:function(){this.selectList=[],this.productId=this.initData.productId,this.initTree()},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,name:e.nodeData.name},this.pageNo=1,this.initTable(!0,this.selectTree.id)},initTree:function(){var e=this;this.dialogLoading=!0;var t=this;Object(i.treeWarehouse)({}).then(function(e){var a=[],i=e.result.treeList;t.selectTree={pid:i.pid,id:i.id,name:i.name},a.push(i),t.treeData=a,t.initTable(!1,t.selectTree.id),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(t){e.dialogLoading=!1})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(n.j)(e.result),a=this.addTableTitle(t);this.configs.tableConfigs=a,this.configs.showCheckBox=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var a in e){var i=e[a];i.indexOf("_")>0&&("en"==o.a.locale?i=i.substring(i.indexOf("_")+1):"zh"==o.a.locale&&(i=i.substring(0,i.indexOf("_")))),t.tempLable[a]=i}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==o.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==o.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),e},initTable:function(e,t){var a=this;null!=t&&0!=t.trim().length||(t=""),e&&(this.BaseTableLoading=!0),Object(i.findListWarehouseByWarehouseProduct)(function(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},i=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),i.forEach(function(t){r(e,t,a[t])})}return e}({},this.tempQuery,{productId:this.productId,nodeId:t,warehouseId:t,pageNo:this.pageNo})).then(function(t){a.getListPage(t),a.dialogLoading=!1,e&&(a.BaseTableLoading=!1)}).catch(function(e){a.dialogLoading=!1,a.BaseTableLoading=!1})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",this.selectList,this.initData.temp)},dataBridge:function(e){if(null!=e&&e.length>0){var t=e[0];t.pageName="dialogChangeWarehouseByIn",this.selectList.push(t)}},save:function(){this.isVisible=!1}}},c=(a("oGmD"),a("KHd+")),u=Object(c.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"500px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:4}},[a("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),a("el-col",{attrs:{span:20}},[a("el-row",{staticClass:"tableContent",staticStyle:{"margin-left":"10px"}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.BaseTableLoading,expression:"BaseTableLoading"}],staticStyle:{height:"400px"}},[a("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,isSingle:e.configs.isSingle,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)]),e._v(" "),a("el-row",{staticStyle:{height:"100px","text-align":"center"}},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogWarehouseByWarehouseProduct.vue";t.default=u.exports},lNSx:function(e,t,a){"use strict";a("rE2o"),a("ioFf"),a("Oyvg"),a("pIFo"),a("f3/d");var i=a("yO6P"),n=a("Yfch");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var r={},l=function(e){i.a.hasOwnProperty(e)&&(r[e]=function(t){return[{validator:function(e){var t=i.a[e]||"";return function(e,a,i){var r,l,s;e.ops&&"object"===o(e.ops)?(e.ops.len?r=l=e.ops.len-0:(r=Object(n.b)(e.ops.min)?e.ops.min:0,l=Object(n.b)(e.ops.max)?e.ops.max:0),s=l>=r?r+","+(l||""):"0,",t=e.ops.customReg&&"string"==typeof e.ops.customReg?e.ops.customReg:t.replace(/placeholder/g,s)):t=t.replace(/placeholder/g,"0,"),a?new RegExp(t,"g").test(a)?i():i(" "):i()}}(e),trigger:"change",ops:t}]})};for(var s in i.a)l(s);t.a=r},oGmD:function(e,t,a){"use strict";var i=a("sEP/");a.n(i).a},"sEP/":function(e,t,a){},tQma:function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf"),a("Oyvg"),a("rGqo");var i=a("7cmB"),n=a("T8OQ"),o=a("UHWX");a("z0WU");function r(e){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.change(scope.row,scope.$index)">更改货位</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},s={components:{treeFormTable:i.a,dialogWarehouseByWarehouseProduct:n.default},name:"dialog-add",props:["initData","visible"],data:function(){return{executeDataArray:[],rootData:{},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},currentpage:1,customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:l,change:this.change}]},editable:{count:{type:"input"}},apiObj:{apiName:"findListByWarehouseInExecutor",params:{firstFieldCode:"productCode,productName,productSpec,productGenreName,productUnitName,count,executeCount,surplusCount,code,warehouseName",secondFieldCode:"",queryStr:"",pageNo:1}},addedData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{productId:"",title:"",temp:{}},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{}}},created:function(){var e="",t=this.initData.temp;null!=t&&t.length>0&&t.forEach(function(t){null!=t.id&&t.id.trim().length>0&&(e=0==e.length?"'"+t.id.trim()+"'":e+",'"+t.id.trim()+"'")});var a="";null!=e&&e.trim().length>0&&(a="a.id in ("+e+")"),this.apiObj.params.queryStr=a},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=r(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(e){},sendChildrenRow:function(e){},change:function(e,t){var a="";null!=e&&null!=e.productId&&e.productId.trim().length>0&&(a=e.productId.trim()),this.dialogData.temp=e,this.dialogData.productId=a,this.dialogData.title="选择货位",this.openDialogName="dialogWarehouseByWarehouseProduct",this.showDialog=!0,this.inLinVisible=!0},dataBridge:function(e){},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},addExecute:function(){this.$refs.treeFormTable.getData()},formData:function(e){this.addWarehouseInExecute(e)},addWarehouseInExecute:function(e){var t=this;this.executeDataArray=[];var a=e.tableData;if(null!=a&&0!=a.length){this.executeDataArray=this.findExecuteDataArray(a);var i=this.checkColumnExecuteArray(this.executeDataArray);if(null!=i&&i.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:i});else{var n=JSON.stringify(a);Object(o.addWarehouseInExecute)({executeJsonStr:n}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请填写入库信息！"})},findExecuteDataArray:function(e){var t=this;return null==e||0==e.length?this.executeDataArray:(e.forEach(function(e){var a=e.children;null!=a&&a.length>0&&a.forEach(function(e){var a={warehouseId:"",count:""};a.warehouseId=e.warehouseId,a.count=e.count,t.executeDataArray.push(a)})}),this.executeDataArray)},checkColumnExecuteArray:function(e){var t="";null!=e&&0!=e.length||(t="请填写入库信息！");for(var a=0;a<e.length;a++){var i=e[a];if(null!=i.warehouseId&&0!=i.warehouseId.trim().length||(t=t+"第 "+(a+1)+" 行: (入库货位id)为空或空字符串;"),null==i.count||0==i.count.trim().length)t=t+"第 "+(a+1)+" 行: (入库数量)为空或空字符串，(入库数量)为必填项不可为空;";else{var n=i.count.trim();new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(n)||(t=t+"第 "+(a+1)+" 行: 入库数量("+i.count.trim()+")输入错误，请输入大于零的正整数或(1,2)位小数！")}}return t},closeDialog:function(e,t){var a=this.$storage.get("userInfo"),i={detailId:"",executorId:"",executorName:"",warehouseId:"",pathName:"",stockCount:null,count:null};if(null!=e&&e.length>0){var n=e[0];i.detailId=t.id,i.executorId=a.userId,i.executorName=a.userName,i.warehouseId=n.id,i.pathName=n.pathName,i.stockCount=n.stockCount,this.addedData={rowData:i,parentData:t}}this.showDialog=!1}},watch:{pageNo:function(){this.initTable()}}},c=a("KHd+"),u=Object(c.a)(s,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1200px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-row",{staticStyle:{height:"600px","margin-top":"15px",width:"96%","margin-left":"2%","margin-bottom":"5px"}},[a("tree-form-table",{ref:"treeFormTable",attrs:{"expand-all":!0,initData:e.rootData,configs:e.tableSets,currentpage:e.currentpage,customColumn:e.customColumn,editable:e.editable,apiObj:e.apiObj,addedData:e.addedData},on:{"update:currentpage":function(t){e.currentpage=t},"get-data":e.formData,"send-children-row":e.sendChildrenRow,databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addExecute}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="dialogExecute.vue";t.default=u.exports},yO6P:function(e,t,a){"use strict";var i=a("YP4+"),n={};n[i.a.code]="^[A-Za-z0-9]{placeholder}$",n[i.a.number]="^[0-9]{placeholder}$",n[i.a.date]="^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$",n[i.a.time]="^([0-2][0-9]\\:[0-5][0-9]\\:[0-5][0-9])|([0-2][0-9]\\:[0-5][0-9])$",n[i.a.mobile]="^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",n[i.a.email]="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",n[i.a.url]="[a-zA-z]+:\\/\\/[^\\s]*",n[i.a.zh]="^[一-龥]{placeholder}$",n[i.a.en]="^[A-Za-z]{placeholder}$",n[i.a.identity]="^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X|x)$",n[i.a.float]="^(-?\\d+\\.\\d+)?$",n[i.a.int]="^-?\\d+$",t.a=n}}]);