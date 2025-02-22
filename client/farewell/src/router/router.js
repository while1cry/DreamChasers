import { createRouter, createWebHistory } from 'vue-router';
import Home from "@/views/Home.vue";
import NameList from "@/views/NameList.vue";
import Error from "@/views/Error.vue";
import NotFound from "@/views/NotFound.vue";


const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
    },
    {
        path: '/namelist',
        name: 'NameList',
        component: NameList,
    },
    {
        path: '/error',
        name: 'Error',
        component: Error,
    },
    {
        path: '/not-found',
        name: 'NotFound',
        component: NotFound,
    },
    {
        path: '/:pathMatch(.*)*',
        redirect: { name: 'NotFound' },
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
