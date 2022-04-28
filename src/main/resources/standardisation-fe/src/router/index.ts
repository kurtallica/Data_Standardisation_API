import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
//import HomeView from "../views/HomeView.vue";
import NewHome from "../views/NewHome.vue";
import SingleStandardiseView from "../views/SingleStandardiseView.vue";
import MultipleStandardiseView from "../views/MultipleStandardiseView.vue";
import FullStandardiseView from "../views/FullStandardiseView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: NewHome,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
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
