(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4eb7"],{BESt:function(t,e,a){"use strict";a.r(e);var i=a("2+ib"),o=a("cTe8"),n=(a("z0WU"),{components:{multilevelTable:i.a},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",data:null,tempLable:null},dialogLoading:!1,isVisible:!1,inDialog:!0,temp:{remark:"齐套分析预采",makeId:""},tempLable:{},tempQuery:{},rowData:{},selectList:[],configs:{topBarBtnList:[]},tempData:{defaultDate:new Date},tableConfigList:[{customColumn:[{columnIndex:"lackCount",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"edate",width:180,componentName:"date",_cellConfig:{valueType:"date",format:"yyyy-MM-dd",valueFormat:"yyyy-MM-dd",greaterThan:["self@cdate",!0]}},{columnIndex:"remark",width:120,componentName:"input",_cellConfig:{rules:[]}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"deleteData",editBtns_isShow:!0,icon:"deleteData",method:this.deleteData}]}],apiObj:{apiName:"getLackProduct",params:{fieldCode:"code,name,spec,unit,stockCount,expectCount,lackCount,edate,remark",dtlJsonStr:this.initData.data}},showIndex:!0,showCheckBox:!1,expand:!1,expandMode:"none",rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){var t=this.$storage.get("userInfo");this.temp.makeId=t.userId},mounted:function(){this.isVisible=this.visible},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},databridge:function(t){Array.isArray(t)?(this.selectList=[],this.selectList=t):(this.rowData=null,null!=t.row&&(this.rowData=t.row))},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},saveOrder:function(){var t=this,e="",a="";if(this.getData(),null!=this.selectList&&0!=this.selectList.length){for(var i=[],n=0;n<this.selectList.length;n++){var s=this.selectList[n],l={productId:"",count:"",reason:"",edate:"",remark:"",id:""};l.productId=s.id,l.count=s.lackCount,l.remark=s.remark,l.edate=s.edate,l.reason="350135d34d1b43aeb4e2977061632045",l.id=s.id,a=a?a+",'"+s.id+"'":"'"+s.id+"'",i.push(l)}e=JSON.stringify(i),this.temp.prodIds=a,this.temp.dtlJsonStr=e,this.$refs.submitForm.validate(function(e){e&&Object(o.checkPurchasePlan)(t.temp).then(function(e){0===e.code&&(e.msg?t.$confirm(e.msg,"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.addPurchasePlan(t.temp)}):t.addPurchasePlan(t.temp))}).catch(function(t){console.log(t)})})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一样货品！"})},addPurchasePlan:function(t){var e=this;this.dialogLoading=!0,Object(o.addPurchasePlan)(t).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1,console.log(t)})},closeDialog:function(t){this.showDialog=!1;null!=t.isConfirm&&t.isConfirm;null!=t.selectList&&t.selectList}},watch:{}}),s=(a("WqLC"),a("KHd+")),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1250px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-row",{staticClass:"tableContent",staticStyle:{height:"450px",width:"96%","margin-left":"2%"}},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.saveOrder}},[t._v("生成采购计划")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);l.options.__file="dialogReport.vue";e.default=l.exports},WqLC:function(t,e,a){"use strict";var i=a("mBQz");a.n(i).a},mBQz:function(t,e,a){}}]);