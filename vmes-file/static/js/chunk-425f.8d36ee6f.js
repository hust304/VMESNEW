(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-425f","szYl","LKBe"],{"/Jhw":function(t,e,i){},"4rN8":function(t,e,i){"use strict";var a=i("/Jhw");i.n(a).a},LKBe:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("xfY5");var a=i("R1DK");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{afterCount:[{required:!0,message:"请填写调整后数量！",trigger:"change"},{type:"number",message:"数量必须为数字值"}]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.beforeCount=this.initData.temp.stockCount)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this,e=this;e.$refs.submitForm.validate(function(i){i&&(e.dialogLoading=!0,Object(a.updateWarehouseProduct)(e.temp).then(function(i){e.dialogLoading=!1,0===i.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,t.initData.temp.stockCount=new Number(e.temp.afterCount).toFixed(2),e.dialogClose({resState:"ok",afterCount:new Number(e.temp.afterCount).toFixed(2)}))}).catch(function(t){e.dialogLoading=!1}))})}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"安全库存调整",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"150px"}},[i("el-form-item",{attrs:{label:"调整前库存数量:",prop:"beforeCount"}},[i("el-input",{staticStyle:{width:"140px"},attrs:{disabled:!0},model:{value:t.temp.beforeCount,callback:function(e){t.$set(t.temp,"beforeCount",e)},expression:"temp.beforeCount"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"调整后库存数量:",prop:"afterCount"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.afterCount,callback:function(e){t.$set(t.temp,"afterCount",t._n(e))},expression:"temp.afterCount"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogStock.vue";e.default=l.exports},szYl:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("xfY5");var a=i("xMja");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{afterCount:[{required:!0,message:"请填写调整后数量！",trigger:"change"},{type:"number",message:"数量必须为数字值"}]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.beforeCount=this.initData.temp.safetyCount)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this,e=this;e.$refs.submitForm.validate(function(i){i&&(e.dialogLoading=!0,Object(a.updateProductSafeStock)({id:e.temp.id,safetyCount:e.temp.afterCount}).then(function(i){e.dialogLoading=!1,0===i.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,t.initData.temp.safetyCount=new Number(e.temp.afterCount).toFixed(2),e.dialogClose({resState:"ok",afterCount:new Number(e.temp.afterCount).toFixed(2)}))}).catch(function(t){e.dialogLoading=!1}))})}}},s=i("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"安全库存调整",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"150px"}},[i("el-form-item",{attrs:{label:"调整前安全库存:",prop:"beforeCount"}},[i("el-input",{staticStyle:{width:"140px"},attrs:{disabled:!0},model:{value:t.temp.beforeCount,callback:function(e){t.$set(t.temp,"beforeCount",e)},expression:"temp.beforeCount"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"调整后安全库存:",prop:"afterCount"}},[i("el-input",{staticStyle:{width:"140px"},model:{value:t.temp.afterCount,callback:function(e){t.$set(t.temp,"afterCount",t._n(e))},expression:"temp.afterCount"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogSafeStock.vue";e.default=l.exports},z6Qk:function(t,e,i){"use strict";i.r(e);i("f3/d"),i("rGqo");var a=i("uTIz"),o=i("2+ib"),n=i("szYl"),s=i("LKBe"),l=i("K3g7"),r=i("R1DK"),c=i("Vobf"),u=(i("z0WU"),{components:{searchBar:a.a,multilevelTable:o.a,dialogSafeStock:n.default,dialogStock:s.default},data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"genreName",configs:{},placeholder:"请输入货品属性"},{label:"货品类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入货品类型"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"库存数量",type:"select",ruleType:"number",mapKey:"orderByStock",configs:{clearable:!0,name:"",options:[{value:0,label:"由多到少"},{value:1,label:"由少到多"}]},placeholder:"请选择"},{label:"安全库存",type:"select",ruleType:"number",mapKey:"isSafeStock",configs:{clearable:!0,name:"",options:[{value:1,label:"小于安全库存"},{value:2,label:"大于等于安全库存"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},configs:{topBarBtnList:[{name:"批量同步",nameEn:"synStockCountAll",isShow:!0,icon:"synStockCountAll",method:this.synStockCountAll}]},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableConfigList:[{customColumn:[{columnIndex:"code"},{columnIndex:"name"},{columnIndex:"genreName"},{columnIndex:"typeName"},{columnIndex:"safetyCount"},{columnIndex:"stockCount"},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"设置安全库存",nameEn:"resetSafeStock",editBtns_isShow:!0,icon:"resetSafeStock",method:this.resetSafeStock},{name:"同步",nameEn:"synStockCountByProduct",editBtns_isShow:!0,icon:"synStockCountByProduct",method:this.synStockCountByProduct}]}],apiObj:{apiName:"listPageWarehouseProductView",params:{}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"手工调整库存",nameEn:"resetStock",editBtns_isShow:!0,icon:"resetStock",method:this.resetStock}]}],apiObj:{apiName:"listPageWarehouseDetailView",params:{}},dynamicValue:{productId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{synStockCountAll:function(){var t=this;Object(r.updateSynStockCount)().then(function(e){0===e.code&&(t.$notify({title:"成功",message:"同步成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){console.log(t)})},synStockCountByProduct:function(t,e){var i=this;Object(r.updateSynStockCount)(t).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"同步成功",type:"success",duration:2e3}),i.updateData(i.searchObj))}).catch(function(t){console.log(t)})},resetSafeStock:function(t,e){this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="安全库存调整",this.openDialogName="dialogSafeStock",this.showDialog=!0,this.visible=!0},resetStock:function(t,e){this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="库存调整",this.openDialogName="dialogStock",this.showDialog=!0,this.visible=!0},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},searchMap:function(t){this.searchObj=t,this.tableConfigList[0].apiObj.params={warehouseId:this.selectTree.id},this.tableConfigList[1].apiObj.params={warehouseId:this.selectTree.id},this.updateData(this.searchObj)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&(this.tableConfigList[0].apiObj.params={warehouseId:this.selectTree.id},this.tableConfigList[1].apiObj.params={warehouseId:this.selectTree.id},this.updateData(this.searchObj))},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(c.initMenuButtons)({menuId:i,roleId:e}).then(function(e){t.$loading().close();var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(console.log(t),t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){console.log(e),t.$loading().close()}))},initTree:function(){var t=this,e=this;Object(l.treeWarehouse)({}).then(function(i){var a=[],o=i.result.treeList;e.selectTree={pid:o.pid,id:o.id,layer:o.layer,name:o.name,virtualGenre:o.virtualGenre},a.push(o),e.treeData=a,t.tableConfigList[0].apiObj.params={warehouseId:t.selectTree.id},t.tableConfigList[1].apiObj.params={warehouseId:t.selectTree.id},t.updateData(t.searchObj),e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)}),e.$loading().close()}).catch(function(t){e.$loading().close()})},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,layer:t.nodeData.layer,name:t.nodeData.name,pathId:t.nodeData.pathId},this.pageNo=1,this.tableConfigList[0].apiObj.params={warehouseId:this.selectTree.id},this.tableConfigList[1].apiObj.params={warehouseId:this.selectTree.id},this.updateData(this.searchObj)},databridge:function(t){this.selectList=t}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),d=(i("4rN8"),i("KHd+")),p=Object(d.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"warehouseBaseManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{staticStyle:{height:"100%",position:"relative"},attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);p.options.__file="index.vue";e.default=p.exports}}]);