import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AuditView from "../views/AuditView.vue";
import SingleStandardiseView from "../views/SingleStandardiseView.vue";
import MultipleStandardiseView from "../views/MultipleStandardiseView.vue";
import FullStandardiseView from "../views/FullStandardiseView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/audit",
    name: "audit",
    component: AuditView,
  },
  {
    path: "/full-standardise",
    name: "full-standardise",
    component: FullStandardiseView,
  },
  {
    path: "/single-standardise",
    name: "single-standardise",
    component: SingleStandardiseView,
  },
  {
    path: "/multiple-standardise",
    name: "multiple-standardise",
    component: MultipleStandardiseView,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
