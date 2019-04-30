(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7e9e"],{VDpm:function(e,t,a){},e1KN:function(e,t,a){"use strict";a.r(t);var n=a("uTIz"),o=a("2+ib"),l=(a("mwzG"),{data:function(){return{searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{hidePicker:!0}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"}],searchMethod:{},searchConfig:{},guid:"",tableConfigList:[{customColumn:[{columnIndex:"progress",sortable:!0},{columnIndex:"count",width:200,componentName:"input",_cellConfig:{rules:[{lessThan:["tempData@count",!1]},{lessThan:["tempData@count(-)sibling@count",!0]}],message:["须小于自定义的count","出库数量总和须小于等于自定义count"],icon:"search"}},{columnIndex:"udate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0],lessThan:["2019-1-31",!1]}},{columnIndex:"productGenreName",componentName:"cascader",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}],outputData:!0,formulaName:"_formula"}},{columnIndex:"progress",componentName:"input",_cellConfig:{compute:"self@count(*)self@productName"}},{columnIndex:"productName",componentName:"switch",_cellConfig:{methodName:"switchEvent",hideTitle:!0}},{columnIndex:"warehouseOutCode",componentName:"steps",_cellConfig:{titleStyle:{"font-weight":600},componentConfig:{titleList:["待审核","待出库","待发货","已发货","已完成"]}}},{columnIndex:"productCode",componentName:"progress",_cellConfig:{titleStyle:{"font-weight":600,color:"#FF9900"},componentConfig:{"text-inside":!1,"stroke-width":18,color:"auto","show-text":!0,baseValue:"count",showInitValue:!1,width:200}}},{columnIndex:"cdate",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"审核通过"},info:{state:"-1",text:"已过期"},warning:{state:"1",text:"已退回"},danger:{state:"2",text:"已拒绝"},default:{state:"0",text:"审核中"}}},{columnIndex:"productSpec",componentName:"button",width:260,_cellConfig:{methodName:"componentMethod",hideTitle:!1}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"新增",nameEn:"add",editBtns_isShow:!0,method:this.reviseData},{name:"删除1",nameEn:"delete1",editBtns_isShow:!0,method:this.deleteAllRow},{name:"删除2",nameEn:"delete2",editBtns_isShow:!0,rowState:"#self@count#===9",method:this.deleteAllRow},{name:"删除3",nameEn:"delete3",editBtns_isShow:!0,method:this.deleteAllRow}]}],apiObj:{apiName:"getBomTreeProduct",params:{}},mergeTitle:[{index:4,alias:"合并后的列",columns:["productUnitName","warehouseOutCode","productCode"],width:400}],keyMapping:{resultKey:{P:"productName"},variableKey:{N:"productSpec"}},tempData:{count:100,defaultDate:"2019-01-21"},useSummary:!0,customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 50%"><span>订单金额：</span><span>￥{{data.orderAmount}}</span></li>\n                    <li style="float: left;width: 50%"><span>应收款：</span><span>￥{{(data.orderAmount - data.rebateAmount - data.accepted)||\'计算错误\'}}</span></li>\n                    <li style="float: left;width: 50%" class="inputStyle">\n                      <span>折扣金额：</span>\n                      <span>￥\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="rebateAmount" :rules="[{ type: \'number\', message: \'必须为数字值\'}]">\n                            <el-input v-model.number="data.rebateAmount" size="mini" placeholder="请输入"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    <li style="float: left;width: 50%"><span style="color: red">逾期金额：</span><span>￥{{data.overdueAmount}}</span></li>\n                    <li style="float: left;width: 50%"><span>已收款：</span><span>￥{{data.accepted}}</span></li>\n                    <li style="float: left;width: 50%"><span>开票金额：</span><span>￥{{data.invoice}}</span></li></ul>'},data:{orderAmount:"1",receivable:"",rebateAmount:"5",overdueAmount:"",accepted:"",invoice:""},boxStyle:{width:"500px",float:"left",padding:"10px"},computes:{orderAmount:"table@productName",accepted:"table@count"}},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"singleTable"}],pushIndex:1,tempItem:null,tempList:[],initData:{}}},components:{searchBar:n.a,multilevelTable:o.a},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},reviseData:function(e){e.count=9,this.$refs.customBaseTable.reviseData(e)},databridge:function(e){console.log(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},sendGuid:function(e){this.guid=e},searchMap:function(e){this.updateData(e)},addChild:function(e,t,a){console.log(e,t,a),this.pushData(e)},deleteAllRow:function(e,t,a){this.deleteData(e)},componentMethod:function(e){console.log(e)},switchEvent:function(e){console.log(e)}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0)+"px":"100%"}},watch:{}}),i=(a("x0HY"),a("KHd+")),s=Object(i.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"singleTable"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight,"margin-top":e.searchList.length?"10px":"0"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge,callmethod:e.callMethod}})],1),e._v(" "),a("div",{staticStyle:{position:"absolute",top:"60px",left:"100px"}},[a("el-button",{on:{click:e.getData}},[e._v("getData")]),e._v(" "),a("el-button",{on:{click:e.pushData}},[e._v("pushData")]),e._v(" "),a("el-button",{on:{click:e.updateData}},[e._v("updateData")]),e._v(" "),a("el-button",{on:{click:e.deleteData}},[e._v("deleteData")]),e._v(" "),a("el-input",{model:{value:e.tableConfigList[0].tempData.count,callback:function(t){e.$set(e.tableConfigList[0].tempData,"count",t)},expression:"tableConfigList[0].tempData.count"}})],1)],1)},[],!1,null,null,null);s.options.__file="index.vue";t.default=s.exports},x0HY:function(e,t,a){"use strict";var n=a("VDpm");a.n(n).a}}]);