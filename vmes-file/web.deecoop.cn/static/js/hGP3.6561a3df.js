(window.webpackJsonp=window.webpackJsonp||[]).push([["hGP3"],{hGP3:function(t,e,i){"use strict";i.r(e);i("91GP");var o={components:{customBaseTable:i("WIyV").a},name:"dialog-option",props:["initData","visible"],data:function(){return{queryForm:{productValue:"",spec:""},title:"",buttonName:"",dialogTopLoading:!1,isVisible:!1,selectList:[],apiObj:{apiName:"listPageProducts",params:{fieldCode:"prodInfo",prodColumnKey:"code,name,spec,property"}},customColumn:[]}},beforeCreate:function(){},created:function(){this.title=this.initData.title},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},computed:{dialogWidth:function(){var t="40%";return null!=this.initData.width&&(t=this.initData.width),t}},methods:{getData:function(){this.$refs.customBaseTable.getData()},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},databridge:function(t){this.selectList=t},dialogClose:function(){"close"==this.buttonName&&(this.selectList=[]),this.$emit("close-dialog",this.selectList,{},this.buttonName)},query:function(){this.apiObj.params=Object.assign({},this.apiObj.params,this.queryForm)},resetQuery:function(){},confirmDialog:function(){this.isVisible=!1},closeDialog:function(){this.isVisible=!1,this.buttonName="close"}},watch:{}},a=i("KHd+"),s=Object(a.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:t.dialogWidth},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[i("el-row",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"10px 10px 10px 10px"}},[i("el-form",{attrs:{inline:!0,model:t.queryForm}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"货品："}},[i("el-input",{staticStyle:{width:"150px"},attrs:{placeholder:"名称或编码"},model:{value:t.queryForm.productValue,callback:function(e){t.$set(t.queryForm,"productValue",e)},expression:"queryForm.productValue"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"规格型号："}},[i("el-input",{staticStyle:{width:"150px"},attrs:{placeholder:"规格型号"},model:{value:t.queryForm.spec,callback:function(e){t.$set(t.queryForm,"spec",e)},expression:"queryForm.spec"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:2}},[t._v(" ")]),t._v(" "),i("el-col",{attrs:{span:6}},[i("el-form-item",[i("base-button",{attrs:{name:"查询",icon:"search"},on:{myclick:t.query}})],1),t._v(" "),i("el-form-item",[i("base-button",{attrs:{name:"重置",icon:"refresh",plain:!0},on:{myclick:t.resetQuery}})],1)],1)],1)],1),t._v(" "),i("el-row",{staticStyle:{padding:"20px 10px 10px 10px"}},[i("custom-base-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"components_dialog_dialogProductOption0",showIndex:!1,showTableSet:!1,showCheckBox:!0,isSingle:!0,customColumn:t.customColumn,apiObj:t.apiObj},on:{callmethod:t.callMethod,databridge:t.databridge}})],1),t._v(" "),i("div",{staticStyle:{height:"60px","text-align":"center"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary",disabled:!t.selectList.length},on:{click:t.confirmDialog}},[t._v("确认")]),t._v(" "),i("el-button",{on:{click:t.closeDialog}},[t._v("取消")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogProductOption.vue";e.default=s.exports}}]);