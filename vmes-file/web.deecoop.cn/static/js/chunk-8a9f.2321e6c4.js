(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-8a9f"],{"/y0O":function(e,t,a){"use strict";var l=a("rikP");a.n(l).a},"1KsK":function(e,t,a){"use strict";a.r(t);a("91GP");var l=a("7cmB"),i=a("uTIz"),o=(a("7lLV"),{props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.addChild(scope.row,scope.$index)">新增下级</el-button>\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.delete(scope.row,scope.$index,scope)">删除</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'}),n={data:function(){return{initData:{},childrenDialogTitleList:[[{label:"物料名称",type:"input",mapKey:"materialName",options:null,placeholder:"请输入"},{label:"规格型号",type:"input",mapKey:"model",options:null,placeholder:"请输入"},{label:"计量单位",type:"input",mapKey:"unit",options:null,placeholder:"请输入"},{label:"物料来源",type:"select",mapKey:"source",options:{disabled:!1,clearable:!0,multiple:!0,filterable:!1,name:"","default-first-option":!1,options:[{value:1,label:"外购"},{value:2,label:"外协"},{value:3,label:"自生产"}]},placeholder:"请选择"},{label:"物料比例",type:"input",mapKey:"ratio",options:null,placeholder:"请输入"}],[{label:"详细名称",type:"input",mapKey:"materialName",options:null,placeholder:"请输入"},{label:"规格型号",type:"input",mapKey:"model",options:null,placeholder:"请输入"},{label:"计量单位",type:"input",mapKey:"unit",options:null,placeholder:"请输入"},{label:"物料来源",type:"select",mapKey:"source",options:{disabled:!1,clearable:!0,multiple:!0,filterable:!1,name:"","default-first-option":!1,options:[{value:1,label:"外购"},{value:2,label:"外协"},{value:3,label:"自生产"}]},placeholder:"请选择"}]],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"}],searchMethod:{},searchConfig:{},guid:"",currentpage:1,searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}],1:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}]},tableSets:{0:{showCheckBox:!1,showIndex:!0,expandOne:!1,isSortable:!1},1:{showCheckBox:!0,showIndex:!0,isSortable:!1,isSingle:!0}},expandTableApiList:["listPageWarehouseOutDetailsDispatch","listPageLogInfo","listPageLogInfo","listPageLogInfo","listPageLogInfo","listPageLogInfo"],expandTableApiParams:[{id:"1001",pid:""},{businessId:"1002"},{businessType:"1003"},{layer:""},{type:""},{userCode:""}],initParams:{},updateViewData:{},editable:{code:{type:"select",rules:[],message:["必须为字母或数字","","须大于取货数量","须小于出库数量"],valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd",placeholder:"选择日期",editable:!1,greaterThan:["2018-11-13 17:30:33","self@stockCount",!0],lessThan:["parent@1@count",!0],shortcuts:["yesterday","today","tomorrow","lastWeek","nextWeek","lastMonth","nextMonth","lastYear","nextYear"],options:[{id:"1",label:"用户1"},{id:"2",label:"用户2",isdisable:"0"},{id:"3",label:"用户3"},{id:"4",label:"用户4"},{id:"5",label:"用户5"}]},stockCount:{type:"select",asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}}},suggestCount:{type:"input",compute:"self@code(+)parent@1@count(*)self@stockCount"}},precision:3,apiObj:{apiName:"listPageWarehouseOutDetailsDispatch",params:{pageNo:1,queryStr:"detail.id in ('219967d2f6704d868b11002caef9885c')"}},addedData:{},testData:{code:"33333333333",companyId:"02b02026270d4b6582b7bfc576e81971",id:"33",isdisable:"1",name:"33",pid:"219967d2f6704d868b11002caef9885c",productId:"",rowState:"1",stockCount:"999",suggestCount:"",warehouseId:"51c314b13c58421085beb3e280cbc122"}}},components:{treeFormTable:l.a,searchBar:i.a},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.treeFormTable.getData()},formData:function(e){},initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.initParams,this.currentpage)).then(function(t){e.initData={row:null,layer:1,res:t,customColumn:e.customColumn}}).catch(function(e){})},sendChildrenRow:function(e,t,a,l,i){var o=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,i)).then(function(a){o.childrenData={row:e,layer:t,res:a,customColumn:o.customColumn}}).catch(function(e){})},setParams:function(e,t,a){var l=this.expandTableApiParams[e-1];for(var i in l)l.hasOwnProperty(i)&&!l[i]&&(l[i]=t[i]||"");return Object.assign({},l,this.searchObj,{pageNo:a})},databridge:function(e){},sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e},handleClose:function(e){var t=this;this.$confirm("确认关闭？").then(function(a){e(),t.showDialog=!1,t.fromTemp={}}).catch(function(e){})},addChild:function(e,t){this.dialogCallBackData=e,this.showDialog=!0,this.dialogVisible=!0},addChildRow:function(){this.dialogVisible=!1,this.showDialog=!1,this.addedData={rowData:this.testData,parentData:this.dialogCallBackData}},createBomTitle:function(e,t,a){var l=this;this.baseLayer++,a.some(function(a){if(l.baseLayer===e)return a.children=l.createTitleList(t),!0;a.children&&a.children.length&&l.searchBomTitle(a.children,e)})},createTitleList:function(e){var t=[];for(var a in e){var l={prop:a,label:a};t.push(l)}return t},searchBomTitle:function(e,t){var a=this;this.baseLayer++,e.some(function(e){if(a.baseLayer===t)return e.children&&e.children.length;e.children&&e.children.length&&a.searchBomTitle(e.children,t)})},deleteRow:function(e,t){},deleteAllRow:function(e,t,a){this.updateViewData={item:e,index:t,all:a,customColumn:this.customColumn}},editRow:function(e,t){}},computed:{setFromLabelWidth:function(){if(this.dialogCallBackData){var e="";switch(this.dialogCallBackData.layer){case 1:e="80px";break;case 2:case 3:default:e="100px"}return e}return"100px"},dialogList:function(){if(this.dialogCallBackData)return this.childrenDialogTitleList[this.dialogCallBackData.layer-1]?this.childrenDialogTitleList[this.dialogCallBackData.layer-1]:this.childrenDialogTitleList[this.childrenDialogTitleList.length-1]},tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{currentpage:function(){this.initExpandTable()}}},s=(a("/y0O"),a("KHd+")),r=Object(s.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"cascadeTable"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[a("tree-form-table",{ref:"treeFormTable",attrs:{"expand-all":!0,initData:e.initData,configs:e.tableSets,currentpage:e.currentpage,customColumn:e.customColumn,editable:e.editable,precision:e.precision,apiObj:e.apiObj,addedData:e.addedData,deleteKey:"index",childHeight:100},on:{"update:currentpage":function(t){e.currentpage=t},"get-data":e.formData,"send-children-row":e.sendChildrenRow,databridge:e.databridge}})],1),e._v(" "),a("div",{staticStyle:{position:"absolute",top:"80px",left:"300px"}},[a("el-button",{on:{click:e.getData}},[e._v("getData")])],1),e._v(" "),e.showDialog?[a("el-dialog",{attrs:{title:"新增下级",visible:e.dialogVisible,width:"400px","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addChildRow}},[e._v("确 定")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"Top Left 提示文字",placement:"top-start"}},[a("el-button",[e._v("上左")])],1)],1)])]:e._e()],2)},[],!1,null,null,null);r.options.__file="index.vue";t.default=r.exports},rikP:function(e,t,a){}}]);