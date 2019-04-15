(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-99aa"],{"+oky":function(e,t,a){},"50Ol":function(e,t,a){"use strict";a("rGqo"),a("KKXr"),a("91GP");var i={name:"custom-summary-option",props:{customSummary:{type:Object,default:function(){return{}}},tableData:{type:Array,default:function(){return[]}},tempData:{type:Object,default:function(){return{}}}},data:function(){return{boxDefaultStyle:{width:"600px",float:"left"},data:{}}},directives:{"send-height":{inserted:function(e,t,a){a.context.$emit("send-height",e.clientHeight)}}},computed:{setStyle:function(){return this.customSummary.boxStyle||this.boxDefaultStyle},setData:function(){return this.customSummary.computes&&this.createFormula(this.customSummary.computes,this.tableData,this.tempData),this.data}},created:function(){this.data=this.customSummary.data,this.customSummary.apiObj&&this.customSummary.apiObj.apiName&&this.httpRequests()},mounted:function(){},methods:{httpRequests:function(){var e=this;try{this.$api[this.customSummary.apiObj.apiName](Object.assign({},this.customSummary.apiObj.params)).then(function(t){t.result&&e.assignmentFn(t.result)}).catch(function(e){console.log(e)})}catch(e){console.log(e)}},assignmentFn:function(e){for(var t in this.data)this.data.hasOwnProperty(t)&&(this.data[t]=e[t])},createFormula:function(e,t,a){for(var i in e)if(e.hasOwnProperty(i)){var n=e[i].split(/\([\\+|\-|\\*|\\/]\)/);if(n.length>1)n.forEach(function(e){});else{var o=e[i].split("@");"table"===o[0]&&(this.data[i]=this.getSum(o[1],t))}}},getSum:function(e,t){var a=0;return t.forEach(function(t){a+=t[e]-0}),a},customSummaryValue:function(e){this.$emit("custom-summary-value",e)}}},n=(a("MtNS"),a("KHd+")),o=Object(n.a)(i,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"customSummaryOption clearfix"},[t(this.customSummary.component,{directives:[{name:"send-height",rawName:"v-send-height"}],tag:"component",attrs:{data:this.setData,tempData:this.tempData,setStyle:this.customSummary.boxStyle},on:{"custom-summary-value":this.customSummaryValue}})],1)},[],!1,null,null,null);o.options.__file="index.vue";t.a=o.exports},Bkt5:function(e,t,a){"use strict";a.r(t);a("91GP");var i=a("uTIz"),n=a("WIyV"),o=(a("z0WU"),a("Yfch"),a("mwzG"),{data:function(){return{searchList:[{label:"货品编码",type:"input",ruleType:"code",ruleOps:{min:6,max:7},mapKey:"goodsCode",configs:{},placeholder:"请输入编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"goodsName",configs:{},placeholder:"请输入货物名"},{label:"盘点时间",type:"select",ruleType:"number",mapKey:"inventoryTime",configs:{clearable:!0,name:"",options:[{value:1,label:"由近到远"},{value:2,label:"由远到近"}]},placeholder:"请选择"},{label:"库存变动时间",type:"select",mapKey:"inventoryChangeTime",configs:{clearable:!0,name:"",options:[{value:1,label:"近3天内"},{value:2,label:"近一周内"},{value:3,label:"近一个月"},{value:4,label:"近三个月"},{value:5,label:"近一年"}]},placeholder:"请选择"},{label:"库存数量",type:"cascader",mapKey:"cascaded",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},placeholder:"请选择"},{label:"盘点日期",type:"date",ruleType:"date",mapKey:"date",configs:{clearable:!0,name:"",type:"date",pickerOptions:{hidePicker:!0}},placeholder:"请选择"},{label:"盘点时间",type:"time",mapKey:"time",configs:{clearable:!0,name:"",pickerOptions:{}},placeholder:"选择时间"}],searchMethod:{},searchConfig:{},searchObj:{},fromTemp:{},showDialog:!1,dialogVisible:!1,dialogCallBackData:null,guid:"",customColumn:[{columnIndex:"count",componentName:"input",_cellConfig:{rules:[{lessThan:["tempData@count",!1]},{lessThan:["tempData@count(-)sibling@count",!0]}],message:["须小于自定义的count","出库数量总和须小于等于自定义count"],icon:"search"}},{columnIndex:"udate",componentName:"date",_cellConfig:{valueType:"date",format:"yyyy年MM月dd日",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0],lessThan:["2019-1-31",!1]}},{columnIndex:"productGenreName",componentName:"cascader",_cellConfig:{asyn:{apiName:"getDictionarys",params:{dictionaryKey:"userType",isglobal:"1"}},rules:[{required:!0}],outputData:!0,formulaName:"_formula"}},{columnIndex:"progress",componentName:"input",_cellConfig:{compute:"self@count(*)self@productName",editable:!1}},{columnIndex:"productName",componentName:"input",_cellConfig:{rules:[{regexp:/\d/g}],message:["必须为数字"]}},{columnIndex:"warehouseOutCode",componentName:"steps",_cellConfig:{titleStyle:{"font-weight":600},componentConfig:{titleList:["待审核","待出库","待发货","已发货","已完成"]}}},{columnIndex:"productCode",componentName:"progress",_cellConfig:{titleStyle:{"font-weight":600,color:"#FF9900"},componentConfig:{"text-inside":!0,"stroke-width":18,color:"#009933","show-text":!0,baseValue:"count",showInitValue:!1,width:200}}},{columnIndex:"cdate",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"审核通过"},info:{state:"-1",text:"已过期"},warning:{state:"1",text:"已退回"},danger:{state:"2",text:"已拒绝"},default:{state:"0",text:"审核中"}}},{columnIndex:"productSpec",width:"140",_cellConfig:{bodyStyle:{color:"#199ED4","font-weight":600},events:{type:"navigation",path:"encapsulation/treeFormTable"},hideTitle:!0}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"新增",nameEn:"add",editBtns_isShow:!0,icon:"add",method:this.addChild},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow},{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteAllRow}]}],apiObj:{apiName:"listPageWarehouseOutDetailsDispatch",params:{pageNo:1,queryStr:"detail.id in ('219967d2f6704d868b11002caef9885c')"}},mergeTitle:[{index:4,alias:"合并后的列",columns:["productUnitName","warehouseOutCode","productCode"]}],mergeColumn:[],mergeRow:[],keyMapping:{resultKey:{P:"productName"},variableKey:{N:"productSpec"}},varList:[],tempList:[],tempData:{count:100,defaultDate:"2019-01-21"},pushIndex:1,tempItem:null,customSummary:{component:{props:["data","setStyle"],template:'<ul class="clearfix" :style="setStyle">\n                    <li style="float: left;width: 50%"><span>订单金额：</span><span>￥{{data.orderAmount}}</span></li>\n                    <li style="float: left;width: 50%"><span>应收款：</span><span>￥{{(data.orderAmount - data.rebateAmount - data.accepted)||\'计算错误\'}}</span></li>\n                    <li style="float: left;width: 50%" class="inputStyle">\n                      <span>折扣金额：</span>\n                      <span>￥\n                        <el-form inline inline-message :model="data" ref="numberValidateForm" label-width="0">\n                          <el-form-item prop="rebateAmount" :rules="[{ type: \'number\', message: \'必须为数字值\'}]">\n                            <el-input v-model.number="data.rebateAmount" size="mini" placeholder="请输入"></el-input>\n                          </el-form-item>\n                        </el-form>\n                      </span>\n                    </li>\n                    <li style="float: left;width: 50%"><span style="color: red">逾期金额：</span><span>￥{{data.overdueAmount}}</span></li>\n                    <li style="float: left;width: 50%"><span>已收款：</span><span>￥{{data.accepted}}</span></li>\n                    <li style="float: left;width: 50%"><span>开票金额：</span><span>￥{{data.invoice}}</span></li></ul>'},data:{orderAmount:"1",receivable:"",rebateAmount:"5",overdueAmount:"",accepted:"",invoice:""},boxStyle:{width:"500px",float:"left",padding:"10px"},apiObj:{apiName:"",params:{}},computes:{orderAmount:"table@productName",accepted:"table@count"}}}},components:{searchBar:i.a,customBaseTable:n.a},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(){this.$refs.customBaseTable.updateTable()},databridge:function(e){console.log(e)},sendGuid:function(e){this.guid=e},searchMap:function(e){console.log(e),this.searchObj=e},handleClose:function(e){var t=this;this.$confirm("确认关闭？").then(function(a){e(),t.showDialog=!1,t.fromTemp={}}).catch(function(e){})},addChild:function(e,t,a){console.log(e,t,a)},addChildRow:function(){},deleteAllRow:function(e,t,a){console.log(e,t,a)}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},setApiObj:function(){return this.apiObj.params=Object.assign({},this.apiObj.params,this.searchObj),this.apiObj}},watch:{}}),s=(a("Whw8"),a("KHd+")),c=Object(s.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"cascadeTable"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px","margin-top":e.searchList.length?"10px":"0"}},[a("custom-base-table",{ref:"customBaseTable",attrs:{varList:e.varList,keyValue:!1,isRemoval:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.setApiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"customBaseTable",showAll:!1,keyMapping:e.keyMapping,tempData:e.tempData,rowKey:"id",useDefaultBtn:!0,useSummary:!0,customSummary:e.customSummary},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticStyle:{position:"absolute",top:"80px",left:"300px"}},[a("el-button",{on:{click:e.getData}},[e._v("getData")]),e._v(" "),a("el-button",{on:{click:e.pushData}},[e._v("pushData")]),e._v(" "),a("el-input",{model:{value:e.tempData.count,callback:function(t){e.$set(e.tempData,"count",t)},expression:"tempData.count"}})],1),e._v(" "),e.showDialog?[a("el-dialog",{attrs:{title:"新增下级",visible:e.dialogVisible,width:"400px","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.addChildRow}},[e._v("确 定")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"Top Left 提示文字",placement:"top-start"}},[a("el-button",[e._v("上左")])],1)],1)])]:e._e()],2)},[],!1,null,null,null);c.options.__file="index.vue";t.default=c.exports},DKCI:function(e,t,a){"use strict";a("rGqo"),a("INYr");var i={name:"table-filter",props:{headerList:{type:Array,default:function(){return[]}},showAll:{type:Boolean,default:!1},storeId:{type:String,default:""},componentId:{type:String,default:""}},directives:{"auto-width":{inserted:function(e,t,a){a.context.widthList[t.value]=e.clientWidth}}},data:function(){return{checkList:[],widthSwitch:!1,checkViewWidth:0,checkViewHeight:0,checkViewWidthTimer:"",widthList:[],userConfig:"",storeKey:"",userId:"",localStoreKey:"",useStore:!1,tempList:""}},created:function(){this.storeKey="tableFilter"+this.storeId,this.userId=this.$storage.get("userInfo").userId||"",this.tempList=this.localStore(this.componentId,this.storeKey,this.userId),this.$emit("checked-list",this.tempList)},computed:{setHeight:function(){return this.checkViewHeight&&this.widthSwitch?(this.$emit("checked-height",this.checkViewHeight),this.checkViewHeight):(this.$emit("checked-height",20),20)},setHeaderList:function(){var e=this;return this.headerList.filter(function(t){return e.showAll?t:!t.component})}},methods:{checkedList:function(e){localStorage.setItem(this.localStoreKey,JSON.stringify(e)),this.$emit("checked-list",e)},viewSwitch:function(){this.widthSwitch=!this.widthSwitch},localStore:function(e,t,a){return this.localStoreKey="_"+e+t+a,JSON.parse(localStorage.getItem(this.localStoreKey))||""},setChecked:function(e){return!this.tempList||!Array.isArray(this.tempList)||this.tempList.findIndex(function(t){return t===e.label})>-1}},watch:{widthSwitch:function(){var e=this;this.widthSwitch&&!this.checkViewHeight&&(clearTimeout(this.checkViewWidthTimer),this.checkViewWidthTimer=setTimeout(function(t){var a=0;e.widthList.forEach(function(e){e-0&&(a+=e+15)}),e.checkViewHeight=20*Math.ceil(a/e.$refs.checkBoxView.clientWidth)},200))}}},n=(a("DlFo"),a("KHd+")),o=Object(n.a)(i,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"tableFilter",style:{height:e.setHeight+"px"}},[a("div",{staticClass:"msg",attrs:{title:"列开关"},on:{click:e.viewSwitch}},[a("svg-icon",{attrs:{"icon-class":"tableSetting"}})],1),e._v(" "),a("div",{ref:"checkBoxView",staticClass:"checkView",class:{setWidth:e.widthSwitch}},[a("div",{staticStyle:{position:"relative"}},[a("div",{staticStyle:{position:"absolute",top:"0",left:"0"}},[a("el-checkbox-group",{attrs:{size:"mini"},on:{change:e.checkedList},model:{value:e.checkList,callback:function(t){e.checkList=t},expression:"checkList"}},e._l(e.setHeaderList,function(t,i){return a("el-checkbox",{directives:[{name:"auto-width",rawName:"v-auto-width",value:i,expression:"index"}],key:t.prop,attrs:{label:t.label,checked:e.setChecked(t)}})}),1)],1)])])])},[],!1,null,"2ad1a997",null);o.options.__file="index.vue";t.a=o.exports},DlFo:function(e,t,a){"use strict";var i=a("kjwg");a.n(i).a},F9dT:function(e,t,a){"use strict";a.d(t,"a",function(){return d}),a.d(t,"c",function(){return l}),a.d(t,"b",function(){return u});a("pIFo"),a("SRfc"),a("KKXr"),a("INYr"),a("rGqo");var i=a("Yfch"),n=a("TB3a"),o=a("YP4+"),s=a("z0WU"),c=function(){return function(e,t,a){var n,o,s;t?(o=t-0,n=!0,s=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,a){a<e.ops.length-1&&(s?Object(i.a)(t-0)?(!Object(i.a)(o)||t-0>o)&&(n=!1):t-0>o&&(n=!1):Object(i.a)(t-0)?(!Object(i.a)(o)||t-0>=o)&&(n=!1):t-0>=o&&(n=!1))}),n?a():a(new Error(e.message))):a(new Error("不能为空"))}},r=function(){return function(e,t,a){var n,o,s;t?(o=t-0,n=!0,s=e.ops[e.ops.length-1],e.ops&&e.ops.length&&e.ops.forEach(function(t,a){a<e.ops.length-1&&(s?Object(i.a)(t-0)?(!Object(i.a)(o-0)||o>t-0)&&(n=!1):o>t-0&&(n=!1):Object(i.a)(t-0)?(!Object(i.a)(o-0)||o>=t-0)&&(n=!1):o>=t-0&&(n=!1))}),n?a():a(new Error(e.message))):a(new Error("不能为空"))}};function d(e,t,a,i,n,o,s,d,u,p,h){var m,f,b,g,y;return e&&(m=l(e.greaterThan,n,o,u,!0,p)),g=d.findIndex(function(e){return e.greaterThan}),t&&(f=l(t.lessThan,n,o,u,!1,p)),y=d.findIndex(function(e){return e.lessThan}),b=[],m&&b.push({validator:c(),trigger:"blur",message:s[h||g],ops:m}),f&&b.push({validator:r(),trigger:"blur",message:s[h||y],ops:f}),b}function l(e,t,a,i,n,o,s){var c;"boolean"==typeof(e=JSON.parse(JSON.stringify(e)))[e.length-1]&&(c=e.pop());var r=e.map(function(e){return""});return e.forEach(function(e,c){var d=e.split(/\([\\+|\-|\\*|\\/]\)/);if(d.length>1)r.splice(c,1,u(d,t,a,i,e,o,s));else if(-1!==e.indexOf("@")){var l=e.split("@");2===l.length&&"self"===l[0]&&r.splice(c,1,t[l[1]]),2===l.length&&"parent"===l[0]&&r.splice(c,1,a[0][l[1]]),2===l.length&&"tempData"===l[0]&&r.splice(c,1,o[l[1]]),2===l.length&&"sibling"===l[0]&&r.splice(c,1,p(l[1],i,t,!1,n)),3===l.length&&"parent"===l[0]&&r.splice(c,1,JSON.parse(JSON.stringify(a)).reverse()[l[1]-1][l[2]])}else r.splice(c,1,e)}),"boolean"==typeof c?r.push(c):r.push(!0),r}function u(e,t,a,c,r,d,l){var u=e.map(function(e){return""});e.forEach(function(e,i){var n=e.split("@"),o=0;if(2===n.length)switch(n[0]){case"self":o=t[n[1]];break;case"parent":o=a[a.length-1][n[1]];break;case"tempData":o=d[n[1]];break;case"sibling":o=p(n[1],c,t,!0)}else 3===n.length?o=JSON.parse(JSON.stringify(a)).reverse()[n[1]-1][n[2]]:1===n.length&&(o=n[0]-0);u.splice(i,1,o||0)});var h=r.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(e){return e.replace(/\(|\)/g,"")}),m="",f=function(e){if(Object(i.a)(e))return"number";if("string"==typeof e&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(e))return"date"}(u[0]);return"number"===f?(u.forEach(function(e,t){h[t]?m+=e+h[t]:m+=e}),parseFloat(Object(s.h)(m).toFixed(l||o.a.precision))):"date"===f?(u.forEach(function(e,t){var a=n.a.timeStamp(e);h[t]?m+=a+h[t]:m+=a}),n.a.formatDate(Object(s.h)(m))):0}function p(e,t,a,i,n){var o=[],s=0,c=t.findIndex(function(e){return e.id===a.id});return t.forEach(function(t,a){c!==a&&o.push(t[e])}),i?o.forEach(function(e){s+=e-0}):s=n?Math.min.apply(Math,o):Math.max.apply(Math,o),s}},MtNS:function(e,t,a){"use strict";var i=a("Mugr");a.n(i).a},Mugr:function(e,t,a){},TB3a:function(e,t,a){"use strict";a("a1Th"),a("SRfc"),a("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===a?(new Date).getTime():new Date(a[1],a[3]-1,a[4]).getTime()}var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),n=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return i&&n?new Date(i[1],i[3]-1,i[4],n[1],n[3],n[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var a=e?new Date(e):new Date,i=a.getFullYear(),n=a.getMonth()+1,o=a.getDate(),s=a.getHours(),c=a.getMinutes(),r=a.getSeconds(),d=function(e){return(e=e.toString())[1]?e:"0"+e};return[i,n,o].map(d).join(t||"-")+" "+[s,c,r].map(d).join(":")}}},Whw8:function(e,t,a){"use strict";var i=a("+oky");a.n(i).a},kjwg:function(e,t,a){},mwzG:function(e,t,a){"use strict";t.a={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","parentId","warehouseId","productId","code","executeCount","state","cuser","uuser","remark","isdisable","qrcode","businessId"],pageData:{current:1,pages:"1",records:[],size:10,total:"1"},titles:[{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{state:"状态"},{cuser:"创建用户id"},{cdate:"创建时间"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"}],varList:[{businessId:"",cdate:"3",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",isdisable1:"1",isdisable2:"0",isdisable3:"1",isdisable4:"1",name:"12",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.jpg",imgPath:"fileUpload/QRCode/product/1539142716704586.png",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",isdisable2:"1",isdisable3:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"219967d2f6704d868b11002caef9885c",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"2",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"111",productSpec:"22222222222222222222",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"3"},{businessId:"",cdate:"1",children:[{code:"11111111111",companyId:"02b02026270d4b6582b7bfc576e81971",id:"11",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"5.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"},{code:"222222222222",companyId:"02b02026270d4b6582b7bfc576e81971",id:"22",isdisable:"1",name:"11",pid:"219967d2f6704d868b11002caef9885c",productId:"01de8e2c87074f06b32567d7c1275808",stockCount:"6.00",suggestCount:"5.00",warehouseId:"51c314b13c58421085beb3e280cbc122"}],code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",hideTitles:["id","warehouseId","productId","isdisable","companyId"],id:"885c219967d2f6704d868b11002caef9",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"3",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:[],productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2111111111111111111",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",titles:[{name:"货位名称"},{code:"批次号"},{stockCount:"库存数量"},{suggestCount:"建议取货数量"},{id:"id"},{warehouseId:"仓库货位ID"},{productId:"产品ID"},{isdisable:"是否启用"},{companyId:"公司ID"}],udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"2"}]}}}}]);