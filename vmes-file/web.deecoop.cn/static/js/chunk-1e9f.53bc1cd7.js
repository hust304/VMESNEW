(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1e9f"],{FYU4:function(e,a,t){"use strict";var n=t("ZkDz");t.n(n).a},ZkDz:function(e,a,t){},lTEw:function(e,a,t){"use strict";t.r(a);var n=t("/xN3"),o=t("LGoM"),c=t("4aGx"),l=t("h9vb"),i=t("RYa6"),s={name:"encapsulation-charts",components:{comprehensive:n.a,product:o.a,customer:c.a,staff:l.a,receivables:i.a},data:function(){return{tabs:[{label:"综合",componentName:"comprehensive",tableConfig:{}},{label:"产品",componentName:"product",tableConfig:{}},{label:"客户",componentName:"customer",tableConfig:{}},{label:"员工",componentName:"staff",tableConfig:{}},{label:"应收款",componentName:"receivables",tableConfig:{}}],activeName:"0"}},methods:{handleClick:function(e,a){},databridge:function(e){},callmethod:function(e){}},computed:{},directives:{},created:function(){}},r=(t("FYU4"),t("KHd+")),m=Object(r.a)(s,function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("div",{staticClass:"encapsulationCharts"},[t("el-tabs",{attrs:{type:"card"},on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(a){e.activeName=a},expression:"activeName"}},[e._l(e.tabs,function(a,n){return[t("el-tab-pane",{key:n,attrs:{label:a.label,name:n+""}},[e.activeName===n+""?t(a.componentName,{tag:"component",attrs:{tableConfigList:a.tableConfig},on:{databridge:e.databridge,callmethod:e.callmethod}}):e._e()],1)]})],2)],1)},[],!1,null,null,null);m.options.__file="index.vue";a.default=m.exports}}]);