(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4c6d","chunk-4eb7"],{"9URt":function(e,t,a){"use strict";a.r(t);a("f3/d"),a("rGqo");var i=a("2+ib"),o=a("uTIz"),n=a("BESt"),s=a("z0WU"),l={components:{dialogReport:n.default,multilevelTable:i.a,searchBar:o.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{expectCount:[{required:!0,message:"请输入期望生产数量"},{type:"number",message:"请输入数字"}]},tableConfigList:[{apiObj:{apiName:"getBomTreeProduct",params:{bomId:this.initData.temp.id,productId:this.initData.temp.prodId}},showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"one",rowStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}},{showIndex:!0,showCheckBox:!1,expand:!0,expandMode:"none",headerStyle:{"background-color":"#E4F3FA"}}],openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{},tempLable:{},selectList:[],varList:[]}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},databridge:function(e){this.selectList=e},refreshTable:function(){this.updateData({expectCount:this.temp.expectCount})},createReport:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,setTimeout(function(){e.dialogLoading=!1,e.getData(),e.varList=[],e.createVarList(e.varList,e.selectList),e.selectList[0]&&e.selectList[0].expectCount<=0&&e.temp.expectCount>0?e.$message({type:"warning",duration:5e3,showClose:!0,message:"查询错误，请重新尝试！"}):e.varList.length<=0?e.$message({type:"warning",duration:5e3,showClose:!0,message:"物料充足，无需采购！"}):(e.dialogData.data=JSON.stringify(e.unique(e.varList,"id")),e.dialogData.title="选择货品",e.openDialogName="dialogReport",e.showDialog=!0,e.inLinVisible=!0)},2e3))})},unique:function(e,t){for(var a={},i=[],o=0;o<e.length;o++)a[e[o][t]]?(Object(s.q)(i,a[e[o][t]]),e[o].expectCount=e[o].expectCount+a[e[o][t]].expectCount,e[o].lackCount=e[o].expectCount-e[o].stockCount,i.push(e[o])):(a[e[o][t]]=e[o],i.push(e[o]));return i},createVarList:function(e,t){var a=this;t.forEach(function(t){var i=t.id,o=t.code,n=t.name,s=t.spec,l=t.unit,c=t.stockCount,d=t.children,r=t.expectCount,u=t.lackCount,g=t.layer,p={id:i,code:o,name:n,spec:s,unit:l,stockCount:c,expectCount:r,lackCount:u};u>0&&g>0&&0==d.length&&e.push(p),d.length>0&&a.createVarList(e,d)})},dialogOpen:function(){},dialogClose:function(e){this.$emit("close-dialog",e||{})},closeDialog:function(e,t){this.addedData={rowData:e[0],parentData:t},this.showDialog=!1}},watch:{}},c=(a("xgHm"),a("KHd+")),d=Object(c.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1500px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-row",{staticStyle:{height:"600px","margin-top":"15px",width:"96%","margin-left":"2%","margin-bottom":"5px"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);d.options.__file="dialogAnalysis.vue";t.default=d.exports},BESt:function(e,t,a){"use strict";a.r(t);var i=a("2+ib"),o=a("cTe8"),n=(a("z0WU"),{components:{multilevelTable:i.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"齐套分析预采",makeId:""},tempLable:{},tempQuery:{},rowData:{},selectList:[],configs:{topBarBtnList:[]},tempData:{defaultDate:new Date},tableConfigList:[{customColumn:[{columnIndex:"lackCount",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"edate",width:180,componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0]}},{columnIndex:"remark",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"deleteData",editBtns_isShow:!0,icon:"deleteData",method:this.deleteData}]}],apiObj:{apiName:"getLackProduct",params:{fieldCode:"code,name,spec,unit,lackCount,edate,remark",dtlJsonStr:this.initData.temp}},showIndex:!0,showCheckBox:!1,expand:!1,expandMode:"none",rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){var e=this.$storage.get("userInfo");this.temp.makeId=e.userId},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},databridge:function(e){Array.isArray(e)?(this.selectList=[],this.selectList=e):(this.rowData=null,null!=e.row&&(this.rowData=e.row))},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},saveOrder:function(){var e=this,t="",a="";if(this.getData(),null!=this.selectList&&0!=this.selectList.length){for(var i=[],n=0;n<this.selectList.length;n++){var s=this.selectList[n],l={productId:"",count:"",reason:"",edate:"",remark:"",id:""};l.productId=s.id,l.count=s.lackCount,l.remark=s.remark,l.edate=s.edate,l.reason="350135d34d1b43aeb4e2977061632045",l.id=s.id,a=a?a+",'"+s.id+"'":"'"+s.id+"'",i.push(l)}t=JSON.stringify(i),this.temp.prodIds=a,this.temp.dtlJsonStr=t,this.$refs.submitForm.validate(function(t){t&&Object(o.checkPurchasePlan)(e.temp).then(function(t){0===t.code&&(t.msg?e.$confirm(t.msg,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.addPurchasePlan(e.temp)}):e.addPurchasePlan(e.temp))}).catch(function(e){console.log(e)})})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},addPurchasePlan:function(e){var t=this;this.dialogLoading=!0,Object(o.addPurchasePlan)(e).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1,console.log(e)})},closeDialog:function(e){this.showDialog=!1;null!=e.isConfirm&&e.isConfirm;null!=e.selectList&&e.selectList}},watch:{}}),s=(a("WqLC"),a("KHd+")),l=Object(s.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"1024px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.saveOrder}},[e._v("生成采购计划")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogReport.vue";t.default=l.exports},WqLC:function(e,t,a){"use strict";var i=a("mBQz");a.n(i).a},jGQn:function(e,t,a){},mBQz:function(e,t,a){},xgHm:function(e,t,a){"use strict";var i=a("jGQn");a.n(i).a}}]);