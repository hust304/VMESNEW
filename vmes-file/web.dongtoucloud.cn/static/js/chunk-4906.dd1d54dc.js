(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4906"],{kP7L:function(e,t,l){"use strict";l.r(t);l("91GP");var a=l("lX1r"),i=l("uTIz"),o=(l("7lLV"),{props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.addChild(scope.row,scope.$index)">新增下级</el-button>\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.delete(scope.row,scope.$index,scope)">删除</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'}),n={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.addChild(scope.row,scope.$index)">新增下级</el-button>\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.delete(scope.row,scope.$index,scope)">删除</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},s={data:function(){return{colConfigs:[{prop:"id",label:"id",children:[{prop:"id",label:"id"},{prop:"pid",label:"pid"},{prop:"icon",label:"icon"},{prop:"name2234",label:"name2234"},{prop:"url",label:"url"},{prop:"operate",label:"操作",component:n,addChild:this.addChild,editRow:this.editRow,delete:this.deleteRow}]},{prop:"pid",label:"pid"},{prop:"icon",label:"icon"},{prop:"name",label:"name"},{prop:"url",label:"url"},{prop:"serialNumber",label:"serialNumber"},{prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteRow}],initData:{},childrenDialogTitleList:[[{label:"物料名称",type:"input",mapKey:"materialName",options:null,placeholder:"请输入"},{label:"规格型号",type:"input",mapKey:"model",options:null,placeholder:"请输入"},{label:"计量单位",type:"input",mapKey:"unit",options:null,placeholder:"请输入"},{label:"物料来源",type:"select",mapKey:"source",options:{disabled:!1,clearable:!0,multiple:!0,filterable:!1,name:"","default-first-option":!1,options:[{value:1,label:"外购"},{value:2,label:"外协"},{value:3,label:"自生产"}]},placeholder:"请选择"},{label:"物料比例",type:"input",mapKey:"ratio",options:null,placeholder:"请输入"}],[{label:"详细名称",type:"input",mapKey:"materialName",options:null,placeholder:"请输入"},{label:"规格型号",type:"input",mapKey:"model",options:null,placeholder:"请输入"},{label:"计量单位",type:"input",mapKey:"unit",options:null,placeholder:"请输入"},{label:"物料来源",type:"select",mapKey:"source",options:{disabled:!1,clearable:!0,multiple:!0,filterable:!1,name:"","default-first-option":!1,options:[{value:1,label:"外购"},{value:2,label:"外协"},{value:3,label:"自生产"}]},placeholder:"请选择"}]],fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,baseLayer:0,searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{disabledDate:["2018-09-15","2018-10-20"]}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"}],searchMethod:{},searchConfig:{},guid:"",currentpage:1,searchObj:{},titleList:[],pageData:{},childrenData:{},customColumn:{1:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}],2:[{columnIndex:"last",prop:"operate",label:"操作",component:n,addChild:this.addChild,editRow:this.editRow,delete:this.deleteAllRow}],3:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}],4:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}],5:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}],6:[{columnIndex:"last",prop:"operate",label:"操作",component:o,addChild:this.addChild,delete:this.deleteAllRow}]},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!0,showIndex:!0,isExpands:!1,isSortable:!1,isSingle:!0,expandOne:!1},3:{showCheckBox:!0,isExpands:!1,isSortable:!1,isSingle:!0,expandOne:!1},4:{showCheckBox:!0,showIndex:!0,isExpands:!1,isSortable:!1,isSingle:!0,expandOne:!1},5:{showCheckBox:!0,showIndex:!0,isExpands:!1,isSortable:!1,isSingle:!0,expandOne:!1}},maxLayer:6,expandTableApiList:["listPageLogInfo","listPageLogInfo","listPageLogInfo","listPageLogInfo","listPageLogInfo","listPageLogInfo"],expandTableApiParams:[{id:"1001",pid:""},{businessId:"1002"},{businessType:"1003"},{layer:""},{type:""},{userCode:""}],initParams:{},updateViewData:{}}},components:{expandTable:a.a,searchBar:i.a},beforeCreate:function(){},created:function(){this.initExpandTable()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initExpandTable:function(){var e=this;this.$api[this.expandTableApiList[0]](this.setParams(1,this.initParams,this.currentpage)).then(function(t){e.initData={row:null,layer:1,res:t,customColumn:e.customColumn}}).catch(function(e){console.log(e)})},sendChildrenRow:function(e,t,l,a,i){var o=this;this.$api[this.expandTableApiList[t-1]](this.setParams(t,e,i)).then(function(l){o.childrenData={row:e,layer:t,res:l,customColumn:o.customColumn}}).catch(function(e){console.log(e)})},setParams:function(e,t,l){var a=this.expandTableApiParams[e-1];for(var i in a)a.hasOwnProperty(i)&&!a[i]&&(a[i]=t[i]||"");return Object.assign({},a,this.searchObj,{pageNo:l})},databridge:function(e){console.log(e)},sendGuid:function(e){this.guid=e},searchMap:function(e){console.log(e),this.searchObj=e},handleClose:function(e){var t=this;this.$confirm("确认关闭？").then(function(l){e(),t.showDialog=!1,t.fromTemp={}}).catch(function(e){})},addChild:function(e,t){this.dialogCallBackData=e,this.showDialog=!0,this.dialogVisible=!0},createBomTitle:function(e,t,l){var a=this;this.baseLayer++,l.some(function(l){if(a.baseLayer===e)return l.children=a.createTitleList(t),!0;l.children&&l.children.length&&a.searchBomTitle(l.children,e)})},createTitleList:function(e){var t=[];for(var l in e){var a={prop:l,label:l};t.push(a)}return t},searchBomTitle:function(e,t){var l=this;this.baseLayer++,e.some(function(e){if(l.baseLayer===t)return e.children&&e.children.length;e.children&&e.children.length&&l.searchBomTitle(e.children,t)})},createBomRow:function(e,t,l){this.baseLayer=0,this.searchBomTitle(this.colConfigs,e)||(this.baseLayer=0,this.createBomTitle(e,l,this.colConfigs))},deleteRow:function(e,t){console.log(e)},deleteAllRow:function(e,t,l){console.log(e,t,l),this.updateViewData={item:e,index:t,all:l,customColumn:this.customColumn}},editRow:function(e,t){},addChildBom:function(){console.log(this.fromTemp),this.createBomRow(this.dialogCallBackData.layer,this.dialogCallBackData.id,this.fromTemp),this.dialogVisible=!1,this.showDialog=!1,this.fromTemp={},console.log(this.colConfigs)}},computed:{setFromLabelWidth:function(){if(this.dialogCallBackData){var e="";switch(this.dialogCallBackData.layer){case 1:e="80px";break;case 2:case 3:default:e="100px"}return e}return"100px"},dialogList:function(){if(this.dialogCallBackData)return this.childrenDialogTitleList[this.dialogCallBackData.layer-1]?this.childrenDialogTitleList[this.dialogCallBackData.layer-1]:this.childrenDialogTitleList[this.childrenDialogTitleList.length-1]},tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{currentpage:function(){console.log(this.currentpage),this.initExpandTable()}}},r=(l("nVJ7"),l("KHd+")),p=Object(r.a)(s,function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"cascadeTable"},[e.searchList.length?l("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),l("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[l("expand-table",{attrs:{initData:e.initData,childrenData:e.childrenData,configs:e.tableSets,currentpage:e.currentpage,maxLayer:e.maxLayer,apiObj:{apiName:e.expandTableApiList,apiParams:e.expandTableApiParams},updateViewData:e.updateViewData},on:{"update:currentpage":function(t){e.currentpage=t},"send-children-row":e.sendChildrenRow,databridge:e.databridge}})],1),e._v(" "),e.showDialog?[l("el-dialog",{attrs:{title:"新增下级",visible:e.dialogVisible,width:"400px","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[l("el-form",{staticStyle:{width:"400px",margin:"20px auto",padding:"0 20px"},attrs:{model:e.fromTemp}},[e._l(e.dialogList,function(t,a){return[l("el-form-item",{attrs:{label:t.label,"label-width":e.setFromLabelWidth}},["input"===t.type?[l("el-input",{attrs:{placeholder:t.placeholder},model:{value:e.fromTemp[t.mapKey],callback:function(l){e.$set(e.fromTemp,t.mapKey,l)},expression:"fromTemp[item.mapKey]"}})]:"select"===t.type?[l("el-select",{attrs:{name:t.options.name,disabled:t.options.disabled,clearable:t.options.clearable,multiple:t.options.multiple,filterable:t.options.filterable,"default-first-option":t.options["default-first-option"],placeholder:t.placeholder},model:{value:e.fromTemp[t.mapKey],callback:function(l){e.$set(e.fromTemp,t.mapKey,l)},expression:"fromTemp[item.mapKey]"}},e._l(t.options.options,function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)]:e._e()],2)]})],2),e._v(" "),l("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:e.addChildBom}},[e._v("确 定")]),e._v(" "),l("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),l("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"Top Left 提示文字",placement:"top-start"}},[l("el-button",[e._v("上左")])],1)],1)],1)]:e._e()],2)},[],!1,null,null,null);p.options.__file="index.vue";t.default=p.exports},nVJ7:function(e,t,l){"use strict";var a=l("uEx0");l.n(a).a},uEx0:function(e,t,l){}}]);