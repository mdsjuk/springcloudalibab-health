import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import user1 from './modules/user'
import tagsView from './modules/tagsView'
import permission from './modules/permission'
import settings from './modules/settings'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    user: user1,
    tagsView,
    permission,
    settings
  },
  getters
})

export default store
