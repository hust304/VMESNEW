(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3f56"],{Wjgq:function(e,t,o){"use strict";o.r(t);var a=o("fFUy"),i=o("uTIz"),l=(o("7lLV"),{props:["colConfig","scope"],template:'<div class="btnBox">\n              <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.addChild(scope.row,scope.$index,scope)">新增下级</el-button>\n    \t\t\t\t  <el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.deletes(scope.row,scope.$index,scope)">删除</el-button>\n    \t\t\t\t </div>'}),n={data:function(){return{searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"}],searchMethod:{},searchConfig:{},fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,guid:"",currentpage:1,searchObj:{},customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:l,addChild:this.addChild,deletes:this.deleteAllRow}],1:[{columnIndex:"last",prop:"operate",label:"操作",component:l,addChild:this.addChild,deletes:this.deleteAllRow}]},tableSets:{0:{showCheckBox:!1,showIndex:!0,expandOne:!1,isSortable:!1,showPageData:!0},1:{showCheckBox:!0,showIndex:!0,isSortable:!1,isSingle:!0}},precision:3,apiObj:{apiName:"listPageWarehouseOutDetailsDispatch",params:{pageNo:1,queryStr:"detail.id in ('219967d2f6704d868b11002caef9885c')"}},mergeColumn:{0:[{index:1,columns:[{keyName:"warehouseOutCode",bodyStyle:{color:"#199ED4","font-weight":600},events:{type:"navigation",path:"encapsulation/treeFormTable"}}]},{index:2,columns:["productGenreName",{keyName:"productUnitName",titleStyle:{"font-weight":600,"font-size":"16px",color:"#FF9900"},bodyStyle:{color:"#199ED4","font-weight":600}}]},{index:4,alias:"合并后的列",columns:["productName",{keyName:"productSpec",componentName:"el-steps",titleStyle:{"font-weight":600},componentConfig:{titleList:["待审核","待出库","待发货","已发货","已完成"]}},{keyName:"progress",componentName:"el-progress",titleStyle:{"font-weight":600,color:"#FF9900"},componentConfig:{"text-inside":!0,"stroke-width":18,color:"#009933","show-text":!0}}]},{index:5,columns:[{keyName:"count",componentName:"el-input",componentConfig:{placeholder:"嘎嘎嘎",type:"text",maxlength:"",minlength:"",clearable:!0,disabled:"inputState",size:"small",rule:{notEmpty:!0,type:"float"}},bodyStyle:{color:"#000000","font-weight":600},hideTitle:!0}]}],1:[{index:3,alias:"进度",columns:[{keyName:"stockCount",componentName:"el-progress",titleStyle:{"font-weight":600,color:"#FF9900"},componentConfig:{"text-inside":!1,"stroke-width":16,color:"#199ED4","show-text":!0,baseValue:6,showInitValue:!0}},{keyName:"suggestCount",componentName:"el-progress",titleStyle:{"font-weight":600,color:"#FF9900"},componentConfig:{"text-inside":!1,"stroke-width":16,color:"#009933","show-text":!0,showInitValue:!0}}]}]}}},components:{customRowTable:a.a,searchBar:i.a},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.treeFormTable.getData()},formData:function(e){},databridge:function(e){},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e},handleClose:function(e){var t=this;this.$confirm("确认关闭？").then(function(o){e(),t.showDialog=!1,t.fromTemp={}}).catch(function(e){})},addChild:function(e,t,o){this.dialogCallBackData=e,this.showDialog=!0,this.dialogVisible=!0},addChildRow:function(){this.dialogVisible=!1,this.showDialog=!1},deleteRow:function(e,t){},deleteAllRow:function(e,t,o){},editRow:function(e,t){}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{currentpage:function(){}}},s=(o("iXLt"),o("KHd+")),c=Object(s.a)(n,function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"cascadeTable"},[e.searchList.length?o("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),o("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[o("custom-row-table",{ref:"treeFormTable",attrs:{"expand-all":!1,keyValue:!0,configs:e.tableSets,currentpage:e.currentpage,customColumn:e.customColumn,editable:{},precision:e.precision,apiObj:e.apiObj,mergeColumn:e.mergeColumn},on:{"update:currentpage":function(t){e.currentpage=t},"get-data":e.formData,databridge:e.databridge}})],1),e._v(" "),o("div",{staticStyle:{position:"absolute",top:"80px",left:"300px"}},[o("el-button",{on:{click:e.getData}},[e._v("getData")])],1),e._v(" "),e.showDialog?[o("el-dialog",{attrs:{title:"新增下级",visible:e.dialogVisible,width:"400px","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[o("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{attrs:{type:"primary"},on:{click:e.addChildRow}},[e._v("确 定")]),e._v(" "),o("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),o("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"Top Left 提示文字",placement:"top-start"}},[o("el-button",[e._v("上左")])],1)],1)])]:e._e()],2)},[],!1,null,null,null);c.options.__file="index.vue";t.default=c.exports},iXLt:function(e,t,o){"use strict";var a=o("tTZd");o.n(a).a},tTZd:function(e,t,o){}}]);