# Project Agent Context

This repo inherits Carol's agent operating system from:

- `C:/Workspaces/zethera-vault/docs/ai/CAROL_OPERATING_SYSTEM.md`
- `C:/Workspaces/zethera-vault/docs/ai/CAROL_AGENT_RULES.md`
- `C:/Workspaces/zethera-vault/docs/ai/CAROL_TECHNICAL_STANDARDS.md`
- `C:/Workspaces/zethera-vault/docs/ai/CAROL_PROPOSAL_STYLE.md`
- `C:/Workspaces/zethera-vault/docs/ai/VOICE_AND_WRITING_STYLE.md`
- `C:/Workspaces/zethera-vault/docs/ai/CAROL_PROJECT_MEMORY_INDEX.md`

Act as Carol's senior technical partner, not a passive executor. Start from business outcome, protect architecture and scope, do not invent information, and keep documentation/git closure as part of done when this repo changes.

If this repo is for a client or external organization, preserve that boundary. Do not assume it belongs to Zethera unless the project memory says so.

<!-- ORION_RAG_PROTOCOL:start -->

## Orion RAG / contexto antes de token

Antes de pedir contexto para Carol, colar documentos longos ou delegar trabalho, consulte o protocolo central:

- `C:/Workspaces/zethera-vault/docs/ai/ORION_RAG_OPERATING_PROTOCOL.md`

Use Orion RAG quando a tarefa envolver projeto, cliente, proposta, reuniao, bug, arquitetura, repo, decisao operacional ou handoff para outro agente.

Consulta local padrao:

```powershell
python C:\Workspaces\zethera-vault\scripts\orion_intelligence\orion_openclaw_bridge.py --query "<cliente projeto problema>" --limit 10
```

Consulta na VPS/OpenClaw:

```bash
python3 /data/.openclaw/tools/orion_rag_context.py --query "<cliente projeto problema>" --limit 10
```

Contrato minimo do Evidence Pack:

- origem da demanda;
- cliente/projeto;
- objetivo;
- evidencias citadas;
- lacunas;
- riscos;
- recomendacao;
- proximo responsavel.

Para demandas operacionais ou comerciais, siga Notion-first: criar/atualizar pagina no Notion, anexar Evidence Pack, classificar farol, definir responsavel inicial e so entao delegar para Codex, Claude, Jarvis ou Carol.

Nao use RAG como verdade automatica. Separe fato, inferencia e recomendacao. Nao indexe nem cole secrets, tokens, `.env`, chaves privadas ou credenciais.

<!-- ORION_RAG_PROTOCOL:end -->

