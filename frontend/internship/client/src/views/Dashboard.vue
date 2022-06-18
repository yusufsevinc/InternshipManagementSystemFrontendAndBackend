
<template>
  <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1>
  <button @click="toggleSidebar">Toggle Sidebar</button> <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1>
  <button @click="toggleSidebar">Toggle Sidebar</button> <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1>
  <button @click="toggleSidebar">Toggle Sidebar</button> <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1>
  <button @click="toggleSidebar">Toggle Sidebar</button> <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1>
  <button class="btn btn-danger" @click="toggleSidebar">Toggle Sidebar</button> <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1>


</template>

<script>
import { collapsed, toggleSidebar } from '@/components/sidebar/state'
export default {
  setup() {
    return { collapsed, toggleSidebar }
  }
}
</script>