<template>
  <div id="edit">
    <br />キャラクター名:
    <input v-model="character.username" type="text" placeholder="キャラクター名" />
    <br />年齢:
    <input v-model="character.age" type="text" placeholder="年齢" />
    <br />職業:
    <input v-model="character.jobs" type="text" placeholder="職業" />
    <br />
    <p>{{character.username}}</p>
    <p>{{character.age}}</p>
    <p>{{character.jobs}}</p>
    <button type="button" @click="updateCharacter(id)">追加</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "edit",
  data: function() {
    return {
      id: this.$route.params.id,
      character: {
        username: undefined,
        age: undefined,
        jobs: undefined
      }
    };
  },
  created: async function() {
    await this.getCharacter(this.id);
  },
  methods: {
    getCharacter: async function(id) {
      const res = await axios.get(
        "http://localhost:8080/api/v1/characters/" + id
      );
      this.character = res.data;
    },
    updateCharacter: async function(id) {
      await axios.put(
        "http://localhost:8080/api/v1/characters/" + id,
        this.character
      );
      await this.getCharacter(id);
    }
  }
};
</script>