<template>
  <div class="dashboard">
    <br />キャラクター名:
    <input
      v-model="character.username"
      type="text"
      placeholder="キャラクター名"
    />
    <br />年齢:
    <input v-model="character.age" type="text" placeholder="年齢" />
    <br />職業:
    <input v-model="character.jobs" type="text" placeholder="職業" />
    <br />
    <p>{{ character.username }}</p>
    <p>{{ character.age }}</p>
    <p>{{ character.jobs }}</p>
    <button type="button" @click="addCharacter">追加</button>
    <table>
      <tr>
        <th>ID</th>
        <th>名前</th>
        <th>年齢</th>
        <th>職業</th>
        <th>編集</th>
        <th>削除</th>
      </tr>
      <tr v-for="(character, key) in characters" :key="key">
        <td>{{ character.id }}</td>
        <td>{{ character.username }}</td>
        <td>{{ character.age }}</td>
        <td>{{ character.jobs }}</td>
        <td>
          <router-link :to="{ path: `/edit/${character.id}` }">
            <button type="button">編集</button>
          </router-link>
        </td>
        <td>
          <button type="button" @click="deleteCharacter(character.id)">
            削除
          </button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Characters",
  data() {
    return {
      characters: [],
      character: {
        username: undefined,
        age: undefined,
        jobs: undefined
      }
    };
  },
  created: async function() {
    await this.refresh();
  },
  methods: {
    refresh: async function() {
      const res = await axios.get("http://localhost:8081/api/v1/characters");
      this.characters = res.data;
    },
    addCharacter: async function() {
      await axios.post(
        "http://localhost:8081/api/v1/characters",
        this.character
      );
      await this.refresh();
    },
    deleteCharacter: async function(id) {
      await axios.delete("http://localhost:8081/api/v1/characters/" + id);
      await this.refresh();
    }
  }
};
</script>
